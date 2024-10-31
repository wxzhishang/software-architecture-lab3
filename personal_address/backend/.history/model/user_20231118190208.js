const mongoose = require("../DB")
const { model } = require("mongoose")
var { Schema } = mongoose

var userSchema = new Schema({
    userId: {
        type: mongoose.Schema.Types.ObjectId,
        required: true,
        unique: true
    },  
    name: String,
    tel: String
})
const userModel = mongoose.model("userTel", userSchema)
module.exports = { userModel }