#!/bin/bash

if [ $# -ne 1 ] || [ ! -f $1 ] ; then
	echo "Usage: $0 <filePath>"
	exit 1
fi
ls -l $1 | tr -s " " | cut -d " " -f5
