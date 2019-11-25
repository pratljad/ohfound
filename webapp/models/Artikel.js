const mongoose = require('mongoose');
const {Schema} = mongoose;

const artikelSchema = new Schema({
    a_id: Number,
    a_description: String,
    a_type: String
})

mongoose.model('artikel', artikelSchema);

/*
db.artikel.insertMany([
    { a_id: 1, a_description: "iPhone 6S+", a_type: "Mobile"},
    { a_id: 2, a_description: "Armani Brieftasche", a_type: "Wallet"},
    { a_id: 3, a_description: "Opel Corsa Schluessel", a_type: "Keys"},
    { a_id: 4, a_description: "Fossil Uhr", a_type: "Watch"},
]);

*/