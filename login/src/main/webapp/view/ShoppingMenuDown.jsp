<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	header{
			height: 10vh;
			border-bottom: 1px solid lightgray;
	        display: flex;
	        justify-content: space-between;
	        align-items: center;
		}
	nav{
		height:10vh;
		display:flex;
		justify-content: center;
		align-items: center;
	}
	.container{
		width:100%;
		display:flex;
	}
	aside{
		width: 15%;
		border: 1px solid lightgray;
	}
	section{
		width: 85%;
		text-align: center;
		display: flex;
		justify-content: space-evenly;
		align-items: center;
		flex-grow: 1;
	}
	footer{
		height:10vh;
		border: 1px solid lightgray;
	}
	article{
		width:30%;
		height: 70vh;
		margin-top: 5vh;
		margin-bottom: 5vh;
		box-shadow: 4px 5px 11px 0px rgba(50, 50, 50, 0.67);
		border-radius: 10px 10px 10px 10px;
	}
	.menuchar{
		padding-right: 7vw;
	}
	#banner{
		padding-left: 5vw;
	}
	#menu{
		width: 75vw;
		display: flex;
		flex-direction: row-reverse;
	}
	#sns {
		padding-top: 1vh;
		padding-right: 2.5vw;	
	}
	#login{
		padding-right: 2vw;
		font-size: 3vh;
		font-weight: bold;
		font-style: italic;
	}
	a:link { color: black; text-decoration: none;}
 	a:visited { color: black; text-decoration: none;}
 	a:hover { color: black; text-decoration: underline;}
</style>
</head>
<body>
	<header>
	        <div id='banner'>
	            <a href='https://naver.com'><img src="..\images.png" alt="Infinity" width="85vw"></a>
	        </div>
	      	<div id='menu'>
	      	    <a href="ShoppingMenuDown.jsp" ><img src="..\menuicon.png" alt="menu" width="40vw"></a>
	        	<a id="login" href='../login.html'>Login</a>
	        </div>
	        <div id='sns'>
	            <a href="https://facebook.com"><img src="..\facebook.png" alt="facebook" width="30vw"></a>
	            <a href="https://twitter.com"><img src="..\twitter.png" alt="twitter" width="30vw"></a>
	        </div>
   		</header>
	<nav>
		<h2 class="menuchar">Home</h2>
		<h2 class="menuchar">About</h2>
		<h2 class="menuchar">Order</h2>
		<h2 class="menuchar">Product</h2>
		<h2 class="menuchar">Service</h2>
	</nav>
	<div class="container">
		<aside>
		</aside>
		<section>
			<article class="showwindow">
			
			</article>
			<article class="showwindow">
			
			</article>
			<article class="showwindow">
			</article>
		</section>
	</div>
	<footer>
	</footer>
</body>
</html>