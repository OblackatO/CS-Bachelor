#!/bin/bash

if [ $# -ne 1  ]; then
	echo "Usage: $0 <programName>"
	exit
fi

program=$1
path=$(which $program)

if [ -z $path  ]; then
	echo "Program $program not found"
	exit
fi

echo "User rights on program $program:"
if [ -r $path ]; then
	echo "- Read"
fi

if [ -w $path ]; then
	echo "- Write"
fi

if [ -x $path ]; then
	echo "- Execute"
fi
