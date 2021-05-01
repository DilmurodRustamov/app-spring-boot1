$(document).ready(function () {
    $("#contact").DataTable({
        ajax: {
            url: '/contact/list',
            method: 'GET',
            dataSrc: ''
        },
        columns: [
            {title: 'Tr', data: "id"},
            {title: 'Ismi', data: "firstName"},
            {title: 'Familiyasi', data: "lastName"},
            {title: 'Otasinig ismi', data: "middleName"},
            {title: 'Raqami', data: "number"},
            {
                title: 'Harakatlar', data: 'id',
                render: function (data, type, row) {
                    return "<div class='row'>" +
                        "<div class='col'><button class='btn btn-warning' id='editContact'>EDIT</button></div>" +
                        "<div class='col'><button class='btn btn-danger' id='deleteContact'>DELETE</button></div>" +
                        "</div>"
                }
            }

        ]
    });


    function editContact(id) {
        console.log(id)
        let obj = document.getElementById(id).textContent;
        console.log(obj)
    }
});
$.ajax({
    url: "/contact/list",
    data: JSON.stringify(data),
    type: "GET",
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    cache: false,
    async: true,
    error: function (jqXHR, error, errorThrown) {
        //display error
    },
    success: function(response) {

        $('#contact').html(response);
    }
})