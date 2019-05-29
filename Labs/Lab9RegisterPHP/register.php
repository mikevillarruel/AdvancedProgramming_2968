<?php
	if($_GET)
	{
		$servername = "localhost";
		$username = "root";
		$passwordDB = "";
		$dbname = "lab10";
		
		$name = $_GET['name'];
		$lastName = $_GET['lastName'];

		// Create connection
		$conn = new mysqli($servername, $username, $passwordDB, $dbname);
		// Check connection
		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
		} 

		$sql = "INSERT INTO names (name, lastName) VALUES ('".$name."','".$lastName."')";

		if ($conn->query($sql) === TRUE) {
			echo "New record created successfully";
		} else {
			echo "Error: " . $sql . "<br>" . $conn->error;
		}

		$conn->close();		
	}
	
?>