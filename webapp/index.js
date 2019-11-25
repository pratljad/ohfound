const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');

// IMPORT MODELS
require('./models/User');
require('./models/Location');
require('./models/Artikel');
require('./models/Inserat');
require('./models/Freigabe');


const app = express();

mongoose.Promise = global.Promise;
mongoose.connect(process.env.MONGODB_URI || `mongodb://localhost:27017/ohfound`);

app.use(bodyParser.json());

//IMPORT ROUTES
require('./routes/userRoutes')(app);
require('./routes/locationRoutes')(app);
require('./routes/artikelRoutes')(app);
require('./routes/inseratRoutes')(app);
require('./routes/freigabeRoutes')(app);

if (process.env.NODE_ENV === 'production') {
    app.use(express.static('ohfoundreact/build'));
  
    const path = require('path');
    app.get('*', (req,res) => {
        res.sendFile(path.resolve(__dirname, 'ohfoundreact', 'build', 'index.html'))
    })
  
  }

const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
  console.log(`app running on port ${PORT}`)
});