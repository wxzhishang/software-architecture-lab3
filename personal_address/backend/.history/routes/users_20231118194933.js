var express = require('express');
var router = express.Router();
var { searchController, createController, deleteController } = require('./controller/index')

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

router.put('/', function(req, res, next) {
  res.send('respond with a resource');
});

router.delete('/:userId', function(req, res, next) {
  const { userId } = req.params
  const code = deleteController(userId)
  res.status(code).send({ code: code })

});


module.exports = router;
