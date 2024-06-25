<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Appointment Management</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Logout</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="row">
            <div class="col-md-12 text-center">
                <h1>Welcome, <%= session.getAttribute("name") %></h1>
                <div class="card-deck mt-4">
                    <div class="card">
                        <img src="images/appointment.jpg" class="card-img-top" alt="Make Appointment">
                        <div class="card-body">
                            <h5 class="card-title">Make Appointment</h5>
                            <p class="card-text">Schedule a new appointment.</p>
                            <a href="makeAppointment.jsp" class="btn btn-primary">Make Appointment</a>
                        </div>
                    </div>
                    <div class="card">
                        <img src="images/cancel.jpg" class="card-img-top" alt="Cancel Appointment">
                        <div class="card-body">
                            <h5 class="card-title">Cancel Appointment</h5>
                            <p class="card-text">Cancel an existing appointment.</p>
                            <a href="cancelAppointment.jsp" class="btn btn-danger">Cancel Appointment</a>
                        </div>
                    </div>
                    <div class="card">
                        <img src="images/display.jpg" class="card-img-top" alt="Display Appointments">
                        <div class="card-body">
                            <h5 class="card-title">Display Appointments</h5>
                            <p class="card-text">View your scheduled appointments.</p>
                            <a href="displayAppointments.jsp" class="btn btn-info">Display Appointments</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
