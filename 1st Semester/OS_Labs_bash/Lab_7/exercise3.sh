#!/bin/sh

#  exercise3.sh
#  
#
#  Created by Pedro Gomes  on 20/12/2017.
#  


if  [ $# == 0 ]; then
    echo "Invalid argument."
    echo "im here1"
    exit 1


elif [[ $# > 0 && ! $# > 1 ]]; then
    if  [ -d "$1" ]; then
        cd $1
        for entry in *; do
            readlink -f $entry
        done
    fi

else
    echo "Invalid arguments."
    echo "im here2"
    exit 1
fi
