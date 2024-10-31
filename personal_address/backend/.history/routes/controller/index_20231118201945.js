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
        list = await userModel.find({},{ _id: 0, __v: 0 })
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

const deleteController = async (userId) => {
    let code = http_code.success
    await userModel.deleteOne({ userId: userId })
    .then(() => {

    }).catch ((e) => {
        code = http_code.error
        console.log('删除失败: ', e)
     })
    return code
}

const updateController = async (data) => {
    let code = http_code.success
    await userModel.findOneAndUpdate(
        { userId: data.userId },
        { $set: { name: data.name, tel: data.tel } },
        { new: true }
    ).then(() => {})
    .catch ((e) => {
        console.log('更新失败: ', e)
        code = http_code.error
     })
    return code
}

module.exports = { searchController, createController, deleteController, updateController }