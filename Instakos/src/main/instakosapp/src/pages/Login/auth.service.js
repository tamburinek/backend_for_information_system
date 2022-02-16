import axios from "axios";
import {useEffect, useState} from "react";
import authHeader from "../../auth-header";

const API_URL = "http://localhost:8080/instakos/auth/";

class AuthService {

    login(username, password) {
        // console.log(username, password);
        return axios
            .post(API_URL + "signin", {
                "username": username, "password": password
            }, {
                headers: {"Content-Type": "application/json; charset=UTF-8"},
                params: {username: username, password: password}
            })
            .then(response => {
                if (response.data.accessToken) {
                    localStorage.setItem("user", JSON.stringify(response.data));
                }

                return response.data;
            });
    }

    logout() {
        localStorage.removeItem("user");
    }


    getCurrentUser() {
        return JSON.parse(localStorage.getItem('user'));
        ;
    }

    getCurrentProfileId(){
        return JSON.parse(localStorage.getItem('user')).profileID;
    }
}

export default new AuthService();
