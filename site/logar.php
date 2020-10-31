<?php
    include "conexao.php";

    $email = $_POST['email'];
    $senha = $_POST['senha'];

	$sql_login="SELECT * FROM tblLogin WHERE email ='$email' AND senha ='$senha'";

    $result = mysqli_query($conn, $sql_login);

	$json = " ";

	if (mysqli_num_rows($result) > 0) {
      	$json = '{"login":"sucesso"}';
    } else {
      $json = '{"login":"erro"}';
    }

	echo $json;
	$conn->close(); 
?>
