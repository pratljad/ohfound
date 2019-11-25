const mongoose = require('mongoose');
const {Schema} = mongoose;

const locationSchema = new Schema({
    loc_id: Number,
    loc_name: String,
    loc_lat: Number,
    loc_lng: Number
})

mongoose.model('locations', locationSchema);