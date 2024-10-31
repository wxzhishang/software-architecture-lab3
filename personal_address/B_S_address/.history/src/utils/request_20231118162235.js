const xhr = new XMLHttpRequest()

function request(method = 'GET', url){
    return new Promise((resolve) => {
                xhr.onreadystatechange = () => {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    resolve(xhr.responseText as T)
                } else {
                    reject(xhr.status)
                }
            }
        }
        xhr.open(method, url, false)
        xhr.send()
    })
}