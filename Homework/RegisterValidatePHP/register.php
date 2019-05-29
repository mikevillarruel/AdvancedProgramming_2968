<?php
	if($_GET)
	{
		$servername = "localhost";
		$username = "root";
		$passwordDB = "";
		$dbname = "lab9";
		
		$user = $_GET['user'];
		$userType = $_GET['userType'];
		$password = $_GET['password'];

		// Create connection
		$conn = new mysqli($servername, $username, $passwordDB, $dbname);
		// Check connection
		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
		} 

		$sql = "INSERT INTO users (user, userType, password)
		VALUES ('".$user."', '".$userType."', '".$password."')";

		if ($conn->query($sql) === TRUE) {
			echo "New record created successfully";
		} else {
			echo "Error: " . $sql . "<br>" . $conn->error;
		}

		$conn->close();		
	}
	
?>