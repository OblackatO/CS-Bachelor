#!/bin/bash

if [ $# -ne 4 ] || [ ! -f $1 ]; then
	echo "Invalid arguments."
	exit 1
fi

if [ ! -d $4 ]; then
	mkdir -p $4
fi

for file in $(cat $1); do
	if [ ! -f $file ]; then
		echo "$file does not exist"
	else
		base=$(basename $file $2)
		if [ $(basename $file) != $base ]; then
			newName=$(echo "$4/$base$3" | tr -s "/" )
			echo "Copying $file to $newName"
			cp $file $newName
		else
			echo "$file does not have the extension $2"
		fi
	fi
done
