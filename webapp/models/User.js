const mongoose = require('mongoose');
const {Schema} = mongoose;

const userSchema = new Schema({
    u_id: Number,
    u_name: String,
    is_verified: Boolean
})

mongoose.model('users', userSchema);

/*db.users.insertMany([
    { u_id: 1, u_name: "Hans Jörg", is_verified: false},
    { u_id: 2, u_name: "Dragan Pratljacic", is_verified: false},
    { u_id: 3, u_name: "Hannes Wirnsberger", is_verified: false},
    { u_id: 4, u_name: "Gabriel Brandner", is_verified: false},
    { u_id: 5, u_name: "Jürgen Fleissner", is_verified: false},
    { u_id: 6, u_name: "Seppo Lego", is_verified: false},
]);
*/