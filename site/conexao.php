<?php
	$servername = "10.100.26.104";
    $username = "root";
    $password = "CHKplq37322";
	$db_name = "Login";


	// Create connection
	$conn = mysqli_connect($servername, $username, $password, $db_name);

	// Check connection
	if ($conn->connect_error) {
    	die("Connection failed: " . $conn->connect_error);
      echo "erro";
	} else {
      //echo "ok";
    }
?>









