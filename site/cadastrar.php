<?php
    include "conexao.php";

    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $senha = $_POST['senha'];


    $sql_verifica="SELECT * FROM tblLogin WHERE email ='$email'";

    $result = mysqli_query($conn, $sql_verifica);

	$json = "";

    if (mysqli_num_rows($result) > 0) {
        // email já cadastrado
        $json = '"cadastro":"erro"}';
    } else {
        //  vai ser cadastrado
        $sql_insert = "INSERT INTO tblLogin (nome, email, senha) VALUES ('$nome', '$email', '$senha')";
        $result = mysqli_query($conn, $sql_insert);
      	echo $result;
    }
    echo $json;

    $conn->close(); 
?>



























