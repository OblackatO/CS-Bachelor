#!/bin/bash

hour=$(date | tr -s " " | cut -d " " -f4 | cut -d ":" -f1)

hour="10#$hour" #forces bash to treat the variable 'hour' as decimal to allow for the arithmetic operations to follow

if (( hour < 12 )); then
	echo "Good morning!"
elif (( hour >= 12 && hour < 17 )); then
	echo "Good afternoon!"
else
	echo "Good evening!"
fi
