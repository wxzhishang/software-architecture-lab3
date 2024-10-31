var express = require('express');
var router = express.Router();
var { searchController, createController, deleteController, updateController } = require('./controller/index')

/* GET users listing. */
router.get('/', async function(req, res, next) {
  const result = await searchController()
  res.status(result.code).send(result);
});

router.post('/', async function(req, res, next) {
  const { name, tel } = req.body
  const code = await createController(name, tel)
  res.status(code).send({ code: code });
});

router.put('/', async function(req, res, next) {
  const data = req.body
  let code = await updateController(data)
  res.status(code).send({ code: code })
});

router.delete('/:userId', async function(req, res, next) {
  const { userId } = req.params
  const code = await deleteController(userId)
  res.status(code).send({ code: code })
});


module.exports = router;
