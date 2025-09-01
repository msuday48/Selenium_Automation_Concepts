package org.example;

public class Poatman {
    /*


// Store booking ID in a collection variable
var bookingid = pm.response.json()["bookingid"];
pm.collectionVariables.set("id", bookingid);

//  Schema validation (ensure you define `schema` before using this test)
pm.test("Validate JSON Schema", function () {
    pm.response.to.have.jsonSchema(schema);
});

// status Code Check
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

//Status code text
pm.test("Body matches string", function () {
    pm.expect(pm.response.text()).to.include("OK");
});

// ✅ Response Time Check
pm.test("Response time is below 5000ms", function () {
    pm.expect(pm.response.responseTime).to.be.below(5000);
});

// ✅ Property Checks in Response Body
pm.test("P1 - Response contains bookingid and booking object", function () {
    let jsonData = pm.response.json();


    pm.expect(jsonData).to.have.property("bookingid");
    pm.expect(jsonData).to.have.property("booking");

    // Booking sub-properties
    pm.expect(jsonData.booking).to.have.property("firstname");
    pm.expect(jsonData.booking).to.have.property("lastname");
    pm.expect(jsonData.booking).to.have.property("totalprice");
    pm.expect(jsonData.booking).to.have.property("depositpaid");
    pm.expect(jsonData.booking).to.have.property("bookingdates");
    pm.expect(jsonData.booking).to.have.property("additionalneeds");

    // Nested object properties
    pm.expect(jsonData.booking.bookingdates).to.have.property("checkin");
    pm.expect(jsonData.booking.bookingdates).to.have.property("checkout");
});

//  Check firstname value (case-sensitive match)
pm.test("Firstname value is 'James'", function () {
    let jsonData = pm.response.json();
    pm.expect(jsonData.booking.get[0].bookingdates.checkin).t0.eql("2018-01-01");
});

//  Check firstname value (case-sensitive match)
pm.test("Firstname value is 'James'", function () {
    let jsonData = pm.response.json();
    pm.expect(jsonData.additionalneeds).to.eql("Breakfast");
});

//NEGETIVE TESTCASES
     */
}
