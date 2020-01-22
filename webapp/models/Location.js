const mongoose = require('mongoose');
const {Schema} = mongoose;

const locationSchema = new Schema({
    loc_id: Number,
    loc_name: String,
    loc_lat: Number,
    loc_lng: Number
})

mongoose.model('locations', locationSchema);

/*db.locations.insertMany([
    { loc_id: 3, loc_name: "KH", loc_lat: 46.6141921, loc_lng: 13.8496302 }
]);*/
/*db.location.insertMany([
    { u_id: 1, u_name: "Hans Jörg", is_verified: false},
    { u_id: 2, u_name: "Dragan Pratljacic", is_verified: false},
    { u_id: 3, u_name: "Hannes Wirnsberger", is_verified: false},
    { u_id: 4, u_name: "Gabriel Brandner", is_verified: false},
    { u_id: 5, u_name: "Jürgen Fleissner", is_verified: false},
    { u_id: 6, u_name: "Seppo Lego", is_verified: false},
]);
*/