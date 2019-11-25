// /routes/productRoute.js
const mongoose = require('mongoose');
const Artikel = mongoose.model('artikel');

module.exports = (app) => {

  app.get(`/api/artikel`, async (req, res) => {
    let artikel = await Artikel.find();
    return res.status(200).send(artikel);
  });

  app.post(`/api/artikel`, async (req, res) => {
    let artikel = await Artikel.create(req.body);
    return res.status(201).send({
      error: false,
      artikel
    })
  })

  app.put(`/api/artikel/:id`, async (req, res) => {
    const {id} = req.params;

    let artikel = await Artikel.findByIdAndUpdate(id, req.body);

    return res.status(202).send({
      error: false,
      artikel
    })

  });

  app.delete(`/api/artikel/:id`, async (req, res) => {
    const {id} = req.params;

    let artikel = await Artikel.findByIdAndDelete(id);

    return res.status(202).send({
      error: false,
      artikel
    })

  })

}