<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>


			<a class="navbar-brand" rel="home" href="#"
				title="Buy Sell Rent Everyting"> <img
				src="${images}/newlogo1.jpg" style="background-color: #0000ff"
				height="30px" width="40px">
			</a>

		</div>

		<div id="bs-example-navbar-collapse-1"
			class="collapse navbar-collapse navbar-responsive-collapse">
			<ul class="nav navbar-nav">
				<li id="home"><a href="${contextRoot}/home">Home</a></li>
				<li id="about"><a href="${contextRoot}/About">About</a></li>
				<li id="contact"><a href="${contextRoot}/contact">Contact</a></li>
				<li id="listProducts"><a
					href="${contextRoot}/show/all/products">View Products</a></li>
				<security:authorize access="hasAuthority('ADMIN')">
					<li id="manageProducts"><a
						href="${contextRoot}/manage/products">Manage Products</a></li>
				</security:authorize>

			</ul>

			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li id="login"><a href="${contextRoot}/login">Login</a></li>
					<li id="reg"><a href="${contextRoot}/Registration">Registration</a></li>
				</security:authorize>

				<security:authorize access="isAuthenticated()">

					<li class="dropdown"><a href="javascript:void(0)"
						class="btn btn-default dropdown-toggle" id="dropdownMenu"
						data-toggle="dropdown"> ${userModel.fullName} <span
							class="caret"></span>

					</a>
						<ul class="dropdown-menu">
							<security:authorize access="hasAuthority('USER')">
								<li><a href="${contextRoot}/cart"> <span
										class="glyphicon glyphicon-shopping-cart"></span> <span
										class="badge">${userModel.cart.cartLine }</span>
										-&#8377;${userModel.cart.grandTotal}

								</a></li>

								<li class="divider" role="seperator"></li>

							</security:authorize>
							<li><a href="${contextRoot}/perform-logout">Logout</a></li>

						</ul></li>
				</security:authorize>
			</ul>

		</div>

	</div>
</nav>

<script>

window.userRole='${userModel}';


</script>

