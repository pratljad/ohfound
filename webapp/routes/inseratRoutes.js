// /routes/productRoute.js
const mongoose = require('mongoose');
const Inserates = mongoose.model('inserate');

module.exports = (app) => {

  app.get(`/api/inserat`, async (req, res) => {
    let inserate = await Inserates.find();
    return res.status(200).send(inserate);
  });

  app.post(`/api/inserat`, async (req, res) => {
    let inserat = await Inserates.create(req.body);
    return res.status(201).send({
      error: false,
      inserat
    })
  })

  app.put(`/api/inserat/:id`, async (req, res) => {
    const {id} = req.params;

    let inserat = await Inserates.findByIdAndUpdate(id, req.body);

    return res.status(202).send({
      error: false,
      inserat
    })

  });

  app.delete(`/api/inserat/:id`, async (req, res) => {
    const {id} = req.params;

    let inserat = await Inserates.findByIdAndDelete(id);

    return res.status(202).send({
      error: false,
      inserat
    })

  })

}