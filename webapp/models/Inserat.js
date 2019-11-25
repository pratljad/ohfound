const mongoose = require('mongoose');
const {Schema} = mongoose;

const inseratSchema = new Schema({
    in_id: Number,
    in_title: String,
    in_creationDate: { type: Date, default: Date.now },
    in_typ: String,
    a_id: Number,
    u_id: Number, 
    coordinates: Array,
    detailed_questions: Array
})

mongoose.model('inserate', inseratSchema);

/*db.inserate.insertMany([
    { in_id: 1, in_title: "iPhone 6S+ naehe Villach", in_creationDate: new Date(), in_typ: "F", a_id: 1, u_id: 1, coordinates: [46.5958896,13.8360096], detailed_questions: ["What is the color of the phone?", "Background picture?"]},
    { in_id: 2, in_title: "Armani Brieftasche verloren!", in_creationDate: new Date(), in_typ: "L", a_id: 2, u_id: 3, coordinates: [46.6158503, 13.8519451], detailed_questions: []},
    { in_id: 3, in_title: "Opel Corsa Schlüssel naehe Atrio", in_creationDate: new Date(), in_typ: "F", a_id: 3, u_id: 2, coordinates: [46.59589, 13.83601], detailed_questions: ["Keychain?", "Color?"]},
]);
*/

/*db.inserates.insertMany([
    { in_id: 1, in_title: "iPhone 6S+ naehe Villach", in_creationDate: new Date(), in_typ: "F", a_id: 1, u_id: 1, coordinates: [46.5829679,13.870207], detailed_questions: ["What is the color of the phone?", "Background picture?"]},
    { in_id: 2, in_title: "Armani Brieftasche verloren!", in_creationDate: new Date(), in_typ: "L", a_id: 2, u_id: 3, coordinates: [46.6158503, 13.8519451], detailed_questions: []},
]);*/

