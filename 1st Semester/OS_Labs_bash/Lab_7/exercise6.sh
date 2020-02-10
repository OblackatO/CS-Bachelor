#!/bin/bash

if [ $# -ne 1 ] || [ ! -d $1 ]; then
	echo "Usage: $0 <directoryPath>"
	exit 1
fi

cd $1

# Directories
directories=""
numberDirectories=0
files=""
numberFiles=0
for entry in *; do
	if [ -d $entry ]; then
		directories="$directories$entry\n"
		(( numberDirectories++ ))
	elif [ -f $entry ]; then
		files="$files$entry\n"
		(( numberFiles++ ))
	fi
done
echo "--- Directories ($numberDirectories) ---"
echo -e $directories
echo "--- Files ($numberFiles) ---"
echo -e $files
