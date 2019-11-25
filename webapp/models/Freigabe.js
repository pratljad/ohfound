const mongoose = require('mongoose');
const {Schema} = mongoose;

const freigabeSchema = new Schema({
    f_id: Number,
    u_id: Number,
    in_id: Number,
    detailed_answers: Array,
    is_resolved: Boolean
})

mongoose.model('freigaben', freigabeSchema);

/*db.freigaben.insertMany([
    { f_id: 1, u_id: 1, in_id: 1, detailed_answers: ["Grey", "Picture of a flower field"] ,is_resolved: false},
    { f_id: 2, u_id: 2, in_id: 2, detailed_answers: [] ,is_resolved: false},
    { f_id: 3, u_id: 3, in_id: 3, detailed_answers: ["Horse Keychain", "Brown"] ,is_resolved: false},
    { f_id: 4, u_id: 4, in_id: 1, detailed_answers: ["Black", "Picture of motorcycle"] ,is_resolved: false},
]);
*/