var express = require('express');
var router = express.Router();
var { searchController, createController } = require('./controller/index')

/* GET users listing. */
router.get('/', async function(req, res, next) {
  const result = await searchController()
  res.status(result.code).send(result);
});

router.post('/', function(req, res, next) {
  console.log(req.body)
  const { name, tel } = req.body
  const code = createController(name, tel)
  res.status(code).send(code);
});

router.put('/', function(req, res, next) {
  res.send('respond with a resource');
});

router.delete('/:id', function(req, res, next) {
  res.send('respond with a resource');
});


module.exports = router;
