#!/bin/sh

#  exercise5.sh
#  
#
#  Created by Pedro Gomes  on 21/12/2017.
#  

if (( $# < 2 )); then
    echo "Pass at least two numbers as arguments."
    exit 1

else
    sum=0
    select choice in "for-loop" "while-loop" "until-loop" ; do
        
        case "$choice" in

            "for-loop")
                for number in "$@"; do
                	(( sum += number ))
                done
                echo "The sum is:$sum"
                exit 1 
                ;;
	       "while-loop")
                while (( $# != 0 )); do
                    ((sum += $1))
                    shift
                done
                echo "The sum is:$sum"
                exit 1 
                ;;
       	    "until-loop")
                until (( $# == 0 )); do
                    ((sum += $1))
                    shift
                done
                echo "The sum is:$sum"
                exit 1 
                ;;

            *)
                echo "Invalid arguments selected."
                ;;
        esac
    done
fi





