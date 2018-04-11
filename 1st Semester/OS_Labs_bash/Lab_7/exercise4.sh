#!/bin/sh

#  exercise4.sh
#  
#
#  Created by Pedro Gomes  on 21/12/2017.
#  


year=-1

if [ $# == 1 ]; then
    year = $1
else
    while [[ $year <  0 ]]; do
        echo "Enter a year:"
        read year
    done
fi


if (( ($year % 4 == 0) && ($year % 100 == 0) && ($year % 400 == 0) )); then
   echo "$year is a leap year."
elif (( ($year%4 == 0) && ($year%100 != 0) )); then
   echo "$year is a leap year."
else
   echo "$year is not a leap year."
fi

#if (( year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) )); then
#   echo "$year is a leap year"
#else
#   echo "$year is not a leap year"
#fi





