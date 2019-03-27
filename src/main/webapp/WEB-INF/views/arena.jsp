<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/styles/arena.css" />" />
    <title>Arena</title>
</head>
<body >
<div class = "background">
    <div class="container">
        <header class="blog-header py-3">
            <div class="row flex-nowrap justify-content-between align-items-center">
                <div class="col-4 pt-1">
                    <a class="text-muted" href="#">
                        <img src="<c:url value="/resources/images/favicon.ico"/>" width="30" height="30" alt="">
                    </a>
                </div>
                <div class="col-4 text-center">
                    <h2 class="text-muted">Politiniai mūšiai</h2>
                </div>
                <div class="col-4 d-flex justify-content-end align-items-center">
                    <div>
                        <a class="btn btn-sm btn-outline-secondary" href="#">Išeiti</a>
                        <a class="btn btn-sm btn-outline-secondary d-none" href="#">Pradėti</a>
                    </div>
                </div>
            </div>
        </header>

        <div class="nav-scroller py-1 mb-2">
            <nav class="nav d-flex justify-content-between">
                <a class="p-2 text-muted" href="#">Kautis</a>
                <a class="p-2 text-muted" href="#">Įvaizdis</a>
                <a class="p-2 text-muted" href="#">Parduotuvė</a>
            </nav>
        </div>

        <div class="jumbotron p-2 p-md-2 text-white rounded bg-dark">
            <div class="col-md-6 px-0">
                <h2 class="font-italic">Kelk savo reitingą!</h2>
            </div>
        </div>

        <div class="row mb-2 "><!--Row-->
            <div class="col-md-6">
                <div class="card flex-md-row mb-4 box-shadow h-md-250"><!--Card-->
                    <div class="card-body d-flex flex-column align-items-start">
                        <!--<strong class="d-inline-block mb-2 text-primary">Juozukas</strong>-->
                        <h3 class="mb-0">
                            <a class="text-primary" href="#">Juozukas</a>
                        </h3>
                        <div class="mb-1 text-muted">Kairioji partija - "Mes už socialinę lygybę!"</div>
                        <p class="card-text mb-1">Reitingas: 500.000</p>
                        <p class="card-text mb-auto">Liko pinigų: 1.000</p>
                        <!--<a href="#">link</a>-->
                    </div>
                    <img class="card-img-right flex-auto d-none d-md-block" src="<c:url value="/resources/images/lzp_bender.png"/>" alt="You">
                </div>
            </div>
            <div class="col-md-6">
                <div class="card flex-md-row mb-4 box-shadow h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                        <!--<strong class="d-inline-block mb-2 text-success">BosasAsCia</strong>-->
                        <h3 class="mb-0 text-dark">
                            <a class="text-primary" href="#">BosasAsCia</a>
                        </h3>
                        <div class="mb-1 text-muted">Centro partija - "Paskolos butelio dėžutėje partija"</div>
                        <p class="card-text mb-1">Reitingas: 1.000.000</p>
                        <p class="card-text mb-auto">Liko pinigų: 2.000</p>
                        <!--<a href="#">link</a>-->
                    </div>
                    <img class="card-img-right flex-auto d-none d-md-block" src="<c:url value="/resources/images/lzp_donald.png"/>" alt="Competitor">
                </div>
            </div>
        </div>
    </div>

    <main role="main" class="container">
        <div class="row mb-2"><!--Row-->
            <div class="col-md-12">
                <div class="card row flex-md-row mb-4 box-shadow h-md-250"><!--Card-->
                    <div class="card-body col-10 d-flex flex-column align-items-start">
                        <table class="table table-sm table-hover table-responsive"><!--Table  with choices-->
                            <thead>
                                <tr>
                                    <th>Taikinys</th>
                                    <th>Priemonė</th>
                                    <th>Pinigai</th>
                                    <th>Puolimas</th>
                                    <th>Gynyba</th>
                                </tr>
                            </thead>
                            <tbody>
                                    <tr>
                                        <td class="form-group">Neturtingi rinkėjai</td>
                                        <td class="form-group">
                                            <select class="form-control" id="Priemone1">
                                                <option>Deficitas: mažinamos pensijos</option>
                                                <option>Skandalas: giminės ministerijoje</option>
                                                <option>Skandalas: suklastotas aukštojo mokslo diplomas</option>
                                                <option>Įstatymas: viešieji darbai už klaidingas turto deklaracija</option>
                                            </select>
                                        </td>
                                        <td>
                                            <input type="number" class="form-control" id="Pinigai1" placeholder="Investicija">
                                        </td>
                                        <td class="text-center">
                                            <input class="form-check-input position-static ml-0" type="checkbox" id="checkbox1p" value="option1" aria-label="...">
                                        </td>
                                        <td class="text-center">
                                            <input class="form-check-input position-static ml-0" type="checkbox" id="checkbox1g" value="option2" aria-label="...">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="form-group">Rinkėjai-teisuoliai</td>
                                        <td class="form-group">
                                            <select class="form-control" id="Priemone2">
                                                <option>Deficitas: mažinamos pensijos</option>
                                                <option>Skandalas: giminės ministerijoje</option>
                                                <option>Skandalas: suklastotas aukštojo mokslo diplomas</option>
                                                <option>Įstatymas: viešieji darbai už klaidingas turto deklaracija</option>
                                            </select>
                                        </td>
                                        <td>
                                            <input type="number" class="form-control" id="Pinigai2" placeholder="Investicija">
                                        </td>
                                        <td class="text-center">
                                            <input class="form-check-input position-static ml-0" type="checkbox" id="checkbox2p" value="option1" aria-label="...">
                                        </td>
                                        <td class="text-center">
                                            <input class="form-check-input position-static ml-0" type="checkbox" id="checkbox2g" value="option2" aria-label="...">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="form-group">Turtingi rinkėjai</td>
                                        <td class="form-group">
                                            <select class="form-control" id="Priemone3">
                                                <option>Deficitas: mažinamos pensijos</option>
                                                <option>Skandalas: giminės ministerijoje</option>
                                                <option>Skandalas: suklastotas aukštojo mokslo diplomas</option>
                                                <option>Įstatymas: viešieji darbai už klaidingas turto deklaracija</option>
                                            </select>
                                        </td>
                                        <td>
                                            <input type="number" class="form-control" id="Pinigai3" placeholder="Investicija">
                                        </td>
                                        <td class="text-center">
                                            <input class="form-check-input position-static ml-0" type="checkbox" id="checkbox3p" value="option1" aria-label="...">
                                        </td>
                                        <td class="text-center">
                                            <input class="form-check-input position-static ml-0" type="checkbox" id="checkbox3g" value="option2" aria-label="...">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="form-group">Neapsisprendę rinkėjai</td>
                                        <td class="form-group">
                                            <select class="form-control" id="Priemone4">
                                                <option>Deficitas: mažinamos pensijos</option>
                                                <option>Skandalas: giminės ministerijoje</option>
                                                <option>Skandalas: suklastotas aukštojo mokslo diplomas</option>
                                                <option>Įstatymas: viešieji darbai už klaidingas turto deklaracija</option>
                                            </select>
                                        </td>
                                        <td>
                                            <input type="number" class="form-control" id="Pinigai4" placeholder="Investicija">
                                        </td>
                                        <td class="text-center">
                                            <input class="form-check-input position-static ml-0" type="checkbox" id="checkbox4p" value="option1" aria-label="...">
                                        </td>
                                        <td class="text-center">
                                            <input class="form-check-input position-static ml-0" type="checkbox" id="checkbox4g" value="option2" aria-label="...">
                                        </td>
                                    </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-img-right col-2 flex-auto d-none d-md-block" >
                        <img src="<c:url value="/resources/images/Lithuania_flag.gif"/>" alt="Flag">
                        <!--<img  src="https://media.giphy.com/media/iaVbaAMws5Nni/giphy.gif" alt="Flag">-->
                        <h3 class="card-text bg-info text-muted text-center d-flex my-auto">Liko rinktis:
                            15s
                        </h3>
                    </div>
                </div>
            </div> <!--Table  with choices-->

        </div><!-- /.row -->
    </main><!-- /.container -->



    <main role="main" class="container">
        <h1>Kovos istorija</h1>
        <div class="row">
            <div class="col-md-6"><!--Table without choices-->
                <div class="card mb-4 box-shadow h-md-250">
                    <div class="table-responsive">
                        <table class="table table-sm table-hover">
                            <thead>
                            <tr>
                                <th>Taikinys</th>
                                <th>Priemonė</th>
                                <th>Puolimas</th>
                                <th>Gynyba</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Neturtingi rinkėjai</td>
                                <td>Deficitas: mažinamos pensijos</td>
                                <td class = "text-center"></td>
                                <td class = "text-center bg-danger"></td>
                            </tr>
                            <tr>
                                <td>Rinkėjai-teisuoliai</td>
                                <td>Skandalas: giminės ministerijoje</td>
                                <td class = "text-center "></td>
                                <td class = "text-center bg-success">500</td>
                            </tr>
                                <td>Turtingi rinkėjai</td>
                                <td>Įstatymas: viešieji darbai už klaidingas turto deklaracijas</td>
                                <td></td>
                                <td></td>
                            </tr>
                                <td>Neapsisprendę rinkėjai</td>
                                <td>Skandalas: suklastotas aukštojo mokslo diplomas</td>
                                <td class = "text-center bg-danger">1.000</td>
                                <td class = "text-center"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div> <!--Table without choices-->
            <div class="col-md-6"><!--Table without choices-->
                <div class="card mb-4 box-shadow h-md-250">
                    <div class="table-responsive">
                        <table class="table table-sm table-hover">
                            <thead>
                            <tr>
                                <th>Taikinys</th>
                                <th>Priemonė</th>
                                <th>Puolimas</th>
                                <th>Gynyba</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Neturtingi rinkėjai</td>
                                <td>Deficitas: mažinamos pensijos</td>
                                <td class = "text-center "></td>
                                <td class = "text-center bg-success">1.000</td>
                            </tr>
                            <tr>
                                <td>Rinkėjai-teisuoliai</td>
                                <td>Skandalas: giminės ministerijoje</td>
                                <td class = "text-center"></td>
                                <td class = "text-center bg-danger"></td>
                            </tr>
                                <td>Turtingi rinkėjai</td>
                                <td>Įstatymas: viešieji darbai už klaidingas turto deklaracijas</td>
                                <td class = "text-center"></td>
                                <td class = "text-center"></td>
                            </tr>
                                <td>Neapsisprendę rinkėjai</td>
                                <td>Skandalas: suklastotas aukštojo mokslo diplomas</td>
                                <td class = "text-center bg-success">2.000</td>
                                <td class = "text-center"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div> <!--Table without choices-->
        </div><!-- /.row -->
    </main><!-- /.container -->

    <footer class="page-footer container">
        <p>
            <a href="#">Į viršų</a>
        </p>
    </footer>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>