const { userModel } = require("../../model/user")
const mongoose = require("mongoose")
const { ObjectId } = mongoose.Types
const http_code = {
    success: 200,
    error: 404
}

const searchController = async () => {
    let list = []
    let code = http_code.success
    try {
        list = await userModel.find()
    }catch (err) {
        console.log('search error: ', err)
        code = http_code.error
    }

    return {
        code: code,
        data: list
    }
}

const createController = async (name, tel) => {
    let code = http_code.success
    await userModel.create({
        userId: new ObjectId(),
        name: name,
        tel: tel
    }).then(() => {
        console.log('添加成功')
    }).catch((e) => {
        console.log('添加遇到异常: ', e)
        code = http_code.error
    })
    return code
}


module.exports = { searchController, createController }