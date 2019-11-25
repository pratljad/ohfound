const mongoose = require('mongoose');
const {Schema} = mongoose;

const messageSchema = new Schema({
    m_id: Number,
    header_id: Number,
    is_from_sender: Boolean,
    m_content: String,
    was_read: Boolean
})

mongoose.model('messages', messageSchema);