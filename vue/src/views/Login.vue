<template>
  <div id="login" class="text-center">
    <form @submit.prevent="login">
      <div class="container">
        <h1>Please Sign In</h1>
        <p
            class="alert alert-danger"
            role="alert"
            v-if="invalidCredentials"
          >Invalid username and password!</p>
        <p
            class="alert alert-success"
            role="alert"
            v-if="this.$route.query.registration"
          >Thank you for registering, please sign in.</p>
        <hr>

        <label for="username"><b>Username</b></label>
        <input type="text" id="username" placeholder="Enter Username" v-model="user.username" required autofocus>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" id="password" v-model="user.password" required>
        
        <hr>
        <button type="submit" class="registerbtn">Sign In</button>
      </div>
      
      <div class="container signin">
        <p>New User? Sign Up <router-link :to="{ name: 'register' }">Here</router-link>!</p>
      </div>
    </form>
    
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/dashboard");
            this.$router.go();
            
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
div {
  font-family: 'Montserrat', sans-serif;
  background-color: #e6e6e6;

}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
  width: 50%;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #f16120;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
