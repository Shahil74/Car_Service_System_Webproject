<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
            color: #333;
        }

        table {
            width: 100%;
            border-spacing: 10px;
        }

        td {
            padding: 10px;
            text-align: left;
        }

        label {
            font-size: 14px;
            color: #555;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            outline: none;
            font-size: 14px;
        }

        input[type="text"]:focus, input[type="password"]:focus {
            border-color: #5b9bd5;
            box-shadow: 0 0 5px rgba(91, 155, 213, 0.5);
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 10px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <form action="/Car-service-system/adminLogin" method="POST">
        <h2>Admin Login</h2>
        <h2>Invalid username</h2>

        <table>
            <tr>
                <td><label for="username">Enter the username:</label></td>
                <td><input type="text" id="username" name="adminusername" required></td>
            </tr>

            <tr>
                <td><label for="password">Enter the password:</label></td>
                <td><input type="password" id="password" name="adminpassword" required></td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="Login">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
