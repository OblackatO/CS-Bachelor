#Question1
data <- read.csv("Assignment2.txt", header=T, sep="\t")
#############################################################

#Question2
#a
number_of_flows <- vector()
number_of_streams <- vector()
for(x in 1:nrow(data)){
  if(data[x,16] > 0){
    number_of_flows <- c(number_of_flows, data[x,1])
    number_of_streams <- c(number_of_streams, data[x,16])
  }
}
plot(x=number_of_flows, y=number_of_streams, xlab="Flows", ylab="Streams", type="p", xlim=c(0,500))

#b
sprintf("Pearson result:%g", cor(number_of_flows, number_of_streams,  use="everything", method="pearson"))

#c
lm_result <- lm(data$ConcisePriorities3classes~data$totalIndividualFlows)
summary(lm_result)$r.squared
abline(lm_result)
#d
sprintf("Feasible: %g -- NOT feasible: %g",nrow(data)-length(number_of_flows), length(number_of_flows))
#################################################################

#Question3
#a
data <- data[sample(nrow(data)),]
#save(data,file="other_name.Rda")
#load(file="shuffled_data.Rda") 
#b
normalize <- function(x) {
  return ((x - min(x)) / (max(x) - min(x)))
}
normalize(c(10, 20, 30, 40, 50))
data_normalized_list <- lapply(data, normalize)
# create a data frame from the list
data_normalized <- as.data.frame(data_normalized_list)

#c/d
start_test = 1
end_test = 1000
start_traning = end_test + 1
end_training = nrow(data)

base_line_features <- data_normalized[, (2:5)]
testing_set <- base_line_features[as.numeric(start_test):as.numeric(end_test),]
training_set <- base_line_features[start_traning:end_training,]

labels <- vector()
for(x in 1:nrow(data)){
  if(data[x,16] == 0){
    labels <- c(labels, "Feasible")
  }else{
    labels <- c(labels, "NOT Feasible")
  }
}

test_labels <- labels[as.numeric(start_test):as.numeric(end_test)]
training_labels <- labels[start_traning:end_training]

#e
library("class")
maximum_k_result <- 0.0
maximum_k_result <- as.integer(maximum_k_result)
right_k <- 0
for(k_value in 1:100){
  k_result = knn(train = training_set, test = testing_set, cl=training_labels , k = k_value)
  temp_result <- sum(as.integer(k_result == test_labels)) / length(test_labels) # ask what it does
  #print(temp_result)
  if(temp_result > maximum_k_result){
    maximum_k_result <- temp_result
    right_k <- k_value
  }
}
sprintf("Optimal k is: %g -- with: %g", right_k, maximum_k_result)

#d
best_k_result <- knn(train = training_set, test = testing_set, cl=training_labels , k = right_k)
library("gmodels")
CrossTable(x = test_labels, y = best_k_result, prop.chisq = FALSE)

#f
#f.1 
for(total_features in 2:16){
  base_line_features <- data_normalized[, (1:total_features)]
  testing_set <- base_line_features[as.numeric(start_test):as.numeric(end_test),]
  training_set <- base_line_features[start_traning:end_training,]
  maximum_k_result <- 0.0
  maximum_k_result <- as.integer(maximum_k_result)
  right_k <- 0
  for(k_value in 1:100){
    k_result = knn(train = training_set, test = testing_set, cl=training_labels , k = k_value)
    temp_result <- sum(as.integer(k_result == test_labels)) / length(test_labels) # ask what it does
    if(temp_result > maximum_k_result){
      maximum_k_result = temp_result
      right_k <- k_value
    }
  }
  print(c(right_k, maximum_k_result, total_features))
  sprintf("Optimal k is: %g -- with: %g -- with total_features: %g", right_k, maximum_k_result, total_features)
}
###################################################################

#Question 4
#a
tmp <- 1:nrow(base_line_features)
folds <- cut(tmp, 10)
#View(folds)
testing_set <- base_line_features[which(folds == "(-3,401]", arr.ind = TRUE), ]
#View(testing_set)
training_set <- base_line_features[401:nrow(base_line_features), ]
#View(training_set)
#labels previously created on question 3c/d
"The testing set is considered to be the first fold, and the 9 others are the training set."
test_labels <- labels[1:400]
training_labels <- labels[401:4000]
#Predicting accuracy of prediction to the given neighbors
sequenceOfNeighbors <-c(1,10,20,30,40,50,60,70,80,90,100)
accuracies <- vector()
for(x in sequenceOfNeighbors){
  k_result = knn(train = training_set, test = testing_set, cl=training_labels , k = x)
  temp_result <- sum(as.integer(k_result == test_labels)) / length(test_labels)  
  accuracies <- c(accuracies, temp_result)
}
plot(x=sequenceOfNeighbors, y=accuracies, xlab="Neighbors", ylab="Accuracies", type="p")

#b
View(data)
normalize_zscore <- function(x) {
  return ((x - mean(x)) / sd(x))
}
data_zscore_normalized_list <- lapply(data, normalize)
# create a data frame from the list
data_zscore_normalized <- as.data.frame(data_zscore_normalized_list)
base_line_features <- data_zscore_normalized[, (2:5)] #test and training data together
#View(base_line_features)
tmp <- 1:nrow(base_line_features)
folds <- cut(tmp, 10)
#View(folds)
testing_set <- base_line_features[which(folds == "(-3,401]", arr.ind = TRUE), ]
#View(testing_set)
training_set <- base_line_features[401:nrow(base_line_features), ]
#View(training_set)
#labels previously created on question 3c/d
#The testing set is considered to be the first fold, and the 9 others are the training set.
test_labels <- labels[1:400]
training_labels <- labels[401:4000]
sequenceOfNeighbors <-c(1,10,20,30,40,50,60,70,80,90,100)
accuracies <- vector()
for(x in sequenceOfNeighbors){
  k_result = knn(train = training_set, test = testing_set, cl=training_labels , k = x)
  temp_result <- sum(as.integer(k_result == test_labels)) / length(test_labels)  
  accuracies <- c(accuracies, temp_result)
}
plot(x=sequenceOfNeighbors, y=accuracies, xlab="Neighbors", ylab="Accuracies", type="p")