#!/bin/sh

#  exercise2.sh
#  
#
#  Created by Pedro Gomes  on 20/12/2017.
#  


select choice in "list contents" "change dir" "create file" "create dir" "remove file" "remove dir" ; do

    case "$choice" in

        "list contents")
            ls -la ;;
        "change dir")
            cd .. ;;
        "create file")
            echo "Name of file to create:"
            read name_file
            touch $name_file;;
        "create dir")
            echo "Name of dir:"
            read name_dir
            mkdir $name_dir;;
        "remove file")
            echo "File to remove:"
            read file_name
            rm $file_name;;
        "remove dir")
            echo "Dir to remove:"
            read dir_name
            rm -R dir_name;;
        *)
            echo "There is no such option."
            ;;
    esac
done
