<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<style>
			body {
			  padding-top: 40px;
			  padding-bottom: 40px;
			  background-color: #eee;
			}
			
			.form-signin {
			  max-width: 330px;
			  padding: 15px;
			  margin: 0 auto;
			}
			.form-signin .form-signin-heading,
			.form-signin .checkbox {
			  margin-bottom: 10px;
			}
			.form-signin .checkbox {
			  font-weight: normal;
			}
			.form-signin .form-control {
			  position: relative;
			  height: auto;
			  -webkit-box-sizing: border-box;
			     -moz-box-sizing: border-box;
			          box-sizing: border-box;
			  padding: 10px;
			  font-size: 16px;
			}
			.form-signin .form-control:focus {
			  z-index: 2;
			}
			.form-signin input[type="email"] {
			  margin-bottom: -1px;
			  border-bottom-right-radius: 0;
			  border-bottom-left-radius: 0;
			}
			.form-signin input[type="password"] {
			  margin-bottom: 10px;
			  border-top-left-radius: 0;
			  border-top-right-radius: 0;
			}
		</style>
	</head>
	<body>
		<form class="form-signin" action="loginUsuario" method="post">
			<h2 class="form-signin-heading">Entrar</h2>
			<form:errors path="servidor.matricula" cssStyle="color:red"/>
			<label for="inputMatricula" class="sr-only">Matrícula</label>
			<input type="text" id="inputMatricula" name="matricula" class="form-control" placeholder="Matrícula" required autofocus>
			<form:errors path="servidor.senha" cssStyle="color:red"/>
			<label for="inputPassword" class="sr-only">Senha</label>
			<input type="password" id="inputPassword" name="senha" class="form-control" placeholder="Senha" required>
			<div class="checkbox">
				<label>
					<input type="checkbox" value="remember-me"> Lembrar-me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</form>
	</body>
</html>