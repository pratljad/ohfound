const mongoose = require('mongoose');
const {Schema} = mongoose;

const headerSchema = new Schema({
    h_id: Number,
    from_id: Number,
    to_id: Number,
    h_status: String,
    time_sent: Date,
    time_recieved: Date
})

mongoose.model('headers', headerSchema);