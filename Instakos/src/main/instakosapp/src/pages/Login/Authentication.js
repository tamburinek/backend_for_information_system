import axios from "axios";

const AUTH_URL = "http://localhost:8080/instakos/signin";

export const authenticateUser = (username, password) => async () => {
    try {
        console.log(username, password)
        const response = await axios.post(AUTH_URL, {
            username: username,
            password: password,
        });
        localStorage.setItem("jwtToken", response.data.token);
        return Promise.resolve(response.data);
    } catch (error) {
        return Promise.reject(error);
    }
};