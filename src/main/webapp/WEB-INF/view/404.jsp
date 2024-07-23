<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 - Page Not Found</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            position: relative; 
            background-color: #FFFFFF; 
        }
        .background-image {
        
            position: absolute;
            top: 0;
            left: 100;
            width: 50%;
            height: 70%;
            z-index: -1;
        }

        .container {
            text-align: center;
            position: relative; 
            z-index: 1; 
        }

        h1 {
            font-size: 48px;
            color: #333;
            margin-bottom: 20px;
        }

        p {
            font-size: 18px;
            color: #666;
        }

        a {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <img class="background-image" src="<%= request.getContextPath() %>/assets/icons/electrocuted-caveman-animation-404-error-page.gif" alt="404 Error">
    <div class="container" style="margin-top: 150px">
        <h1>404 - Page Not Found</h1>
        <p>Oops! Looks like the page you're looking for doesn't exist.</p>
        <p>Go back to <a href="<%= request.getContextPath() %>">home</a>.</p>
    </div>
</body>
</html>
