library("keras")
library("tensorflow")
set.seed(0)
tensorflow::tf$random$set_seed(0)
mnist <- read.csv2( "data.csv", header = T, sep = ",", dec ="." )
labels <- read.csv2("labels.csv", header = F, sep = ",", dec = ".")

#Step1 load data
x_train <- mnist[0:8000,]
y_train <- labels[0:8000,]
x_test <- mnist[8001:9995,]
y_test <- labels[8001:9995,]
x_train <- data.matrix(x_train)
y_train <- data.matrix(y_train)
x_test <- data.matrix(x_test)
y_test <- data.matrix(y_test)


model <-keras_model_sequential() 
# #RELU -- LOSS:'categorical_crossentropy' -- Optimizer: AdaDelta
# model %>%
#   layer_dense(units = 2, activation = 'relu', input_shape = c(6)) %>% #digit probability
# summary(model)
# #compile model with appropriate loss function, optimizer, and metrics
# model %>% compile(
#   loss = 'categorical_crossentropy',
#   optimizer = optimizer_adadelta(lr=0.5),
#   metrics = c('accuracy')
# )

# #Sigmoid-- LOSS:'binary_crossentropy' -- Optimizer: Adam
# model %>%
#   layer_dense(units = 2, activation = 'sigmoid', input_shape = c(6)) %>% #digit probability
#   summary(model)
# #compile model with appropriate loss function, optimizer, and metrics
# model %>% compile(
#   loss = 'binary_crossentropy',
#   optimizer = optimizer_adam(lr=0.05),
#   metrics = c('accuracy')
# )

# #Tanh-- LOSS:'binary_crossentropy' -- Optimizer: Adam
# model %>%
#   layer_dense(units = 2, activation = 'tanh', input_shape = c(6)) %>%
#   summary(model)
# #compile model with appropriate loss function, optimizer, and metrics
# model %>% compile(
#   loss = 'binary_crossentropy', #loss = 'categorical_crossentropy'
#   optimizer = optimizer_adamax(lr=0.05),
#   metrics = c('accuracy')
# )

#[>]BEST MODEL[<] 
#sigmoid-- LOSS:'binary_crossentropy' -- Optimizer: Adamax
model %>%
  layer_dense(units = 2, activation = 'sigmoid', input_shape = c(6)) %>%
  summary(model)
#compile model with appropriate loss function, optimizer, and metrics
model %>% compile(
  loss = 'binary_crossentropy',
  optimizer = optimizer_adamax(lr=0.05),
  metrics = c('accuracy')
)

#see real-time training
history <-model %>% fit(x_train, y_train, epochs = 35, batch_size= 32)
plot(history)

#evaluate test
model %>% evaluate(x_test, y_test)