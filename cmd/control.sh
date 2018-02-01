#!/usr/bin/env bash
	#/bin/sh
	#
	# ---------------------------------------------------------------------
	control=$1
	script_name="momo-account-1.0.jar"
	worker="worker"
	path_worker=`pwd`/$worker
	log_file=$2
	if [ $# -lt 1 ]; then
		echo "[1001]No arguments supplied"
		exit
	fi
	case $control in
		"start" )
	if [ $# -lt 1 ]; then
		echo "[1001]No arguments supplied"
		exit
	fi
	if [ ! -f $script_name ]; then
		echo "[1002]File $script_name not found!"
		exit
	fi
	if [ ! -f $path_worker ]; then
		echo "[1002]File $path_worker not found!"
		exit
	fi
			#Worker
			$path_worker $script_name $log_file &
	        #nohup $path_worker $script_name $interval "null" $log_file &
	        echo "Starting..."
	        sleep 1
	        PID=`ps ax | grep $path_worker | grep $script_name | grep -v grep | grep -v $0 | awk '{print $1}'`
	        num_agent2=$(ps ax | grep $path_worker | grep $script_name | grep -v grep | wc -l)
	        if [ $num_agent2 -eq 1 ]; then
	        	echo "[OK]		Started $path_worker run file $script_name successed with PID is $PID :)"
	        else
	        	echo "[FAILED]		Start $script_name failed :("
	        fi
	        ;;
	        "stop" )
	if [ $# -lt 1 ]; then
		echo "[1001]No arguments supplied"
		exit
	fi
	PID=`ps ax | grep $script_name | grep -v grep | grep -v $0 | awk '{print $1}'`
	if [ "$PID" ==  "" ]; then
		echo "[INFO]		No any $script_name process..."
	else
		echo "Result found:" 
		ps ax | grep $script_name| grep -v grep | grep -v $0
		read -p "Enter worker ID to kill, press 'n' to exit? : " -n 128 -r -e

		if [[ $REPLY =~ ^[0-9a-z]+$ ]];
			then
			if [[ $REPLY =~ [0-9] ]]; then
				echo "Killing PID: $REPLY..."
				`kill -9 $REPLY`
				sleep 1
				count_proc=`ps ax|grep $REPLY | grep -v grep| grep -v $0 | wc -l`
				if [ $count_proc -eq 1 ]; then
					echo "Can't kill proc with pID $REPLY"
				else
					echo "Killed!"
				fi
			else
				echo "Ok, Bye!"
				exit
			fi

		fi
	fi
	;;
	"status" )
			#status SO6Worker

			PID=`ps ax | grep $script_name | grep -v grep | grep -v $0 | awk '{print $1}'`
			if [ "$PID" ==  "" ]; then
				echo "[INFO]            No any worker process..."
			else
				count_worker=`ps ax|grep $script_name | grep -v grep| grep -v $0 | wc -l`
				echo "[INFO]		List worker is running: ($count_worker workers)"
				ps ax | grep $script_name| grep -v grep | grep -v $0
				for pid in $(ps ax | grep $script_name | grep -v grep | grep -v $0 | awk '{print $1}'); 
			do 
				ss -l -p -n | grep ",$pid,"
			done
				
			fi
			;;
			"restart" )
	if [ $# -lt 1 ]; then
		echo "[1001]No arguments supplied"
		exit
	fi
	PID=`ps ax | grep $script_name | grep -v grep | grep -v $0 | awk '{print $1}'`
	if [ "$PID" ==  "" ]; then
		echo "[INFO]		No any $script_name process..."
		$path_worker $script_name $log_file &
		echo "Starting..."
		sleep 1
		PID=`ps ax | grep $path_worker | grep $script_name | grep -v grep | grep -v $0 | awk '{print $1}'`
		num_agent2=$(ps ax | grep $path_worker | grep $script_name | grep -v grep | wc -l)
		if [ $num_agent2 -eq 1 ]; then
			echo "[OK]		Started $path_worker run file $script_name successed with PID is $PID :)"
		else
			echo "[FAILED]		Start $script_name failed :("
		fi
	else
		echo "Result found:" 
		ps ax | grep $script_name| grep -v grep | grep -v $0

		for pid in $(ps ax | grep $script_name | grep -v grep | grep -v $0 | awk '{print $1}'); 
		do 
		`kill -9 $pid`; 
		sleep 1
		count_proc=`ps ax|grep $pid | grep -v grep| grep -v $0 | wc -l`
		if [ $count_proc -eq 1 ]; then
			echo "Can't kill proc with pID $pid"
		else
			echo "Killed $pid."
		fi
		sleep 1
	done
	$path_worker $script_name $log_file &
	echo "Starting..."
	sleep 1
	PID=`ps ax | grep $path_worker | grep $script_name | grep -v grep | grep -v $0 | awk '{print $1}'`
	num_agent2=$(ps ax | grep $path_worker | grep $script_name | grep -v grep | wc -l)
	if [ $num_agent2 -eq 1 ]; then
		echo "[OK]		Started $path_worker run file $script_name successed with PID is $PID :)"
	else
		echo "[FAILED]		Start $script_name failed :("
	fi

fi
;;
esac
