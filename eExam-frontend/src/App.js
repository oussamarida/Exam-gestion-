import "./App.css";
import React, { useState, useEffect } from "react";
import axios from "axios";
import { Calendar } from 'antd';
import "./style.css";



import {
  Page,
  Text,
  Image,
  View,
  Document,
  PDFViewer,
} from "@react-pdf/renderer";

import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInput,
  MDBIcon,
  MDBCollapse,
  MDBNavbar,
  MDBNavbarToggler,
  MDBTabs,
  MDBTabsItem,
  MDBTabsLink,
  MDBTabsPane,
  MDBCo,
  MDBListGroup,
  MDBListGroupItem,
  MDBTabsContent,
  MDBFile,
} from "mdb-react-ui-kit";



function App() {
  let conn_user = null;
  let conv_data = null;

  const [ShowLoginDiv, setShowLoginDiv] = useState(true);
  const [ShowAdminDiv, setShowAdminDiv] = useState(false);
  const [ShowStudentDiv, setShowStudentDiv] = useState(false);
  const [ShowProfDiv, setShowProfDiv] = useState(false);
  function handleShowLoginDiv() {
    setShowLoginDiv(true);
    setShowAdminDiv(false);
    setShowStudentDiv(false);
    setShowProfDiv(false);
  }
  function handleShowAdminDiv() {
    setShowLoginDiv(false);
    setShowAdminDiv(true);
    setShowStudentDiv(false);
    setShowProfDiv(false);
  }
  function handleShowStudentDiv() {
    setShowLoginDiv(false);
    setShowAdminDiv(false);
    setShowStudentDiv(true);
    setShowProfDiv(false);
  }
  function handleShowProfDiv() {
    setShowLoginDiv(false);
    setShowAdminDiv(false);
    setShowStudentDiv(false);
    setShowProfDiv(true);
  }

  const [basicActive, setBasicActive] = useState("upload");

  const handleBasicClick = (value: string) => {
    if (value === basicActive) return;

    setBasicActive(value);
  };
  const [basicActive2, setBasicActive2] = useState("calendar");

  const handleBasicClick2 = (value: string) => {
    if (value === basicActive2) return;

    setBasicActive2(value);
  };
  async function readJSONFile(file) {
    const reader = new FileReader();

    reader.onload = async (event) => {
      const jsonData = JSON.parse(event.target.result);
      const confirmMessage = `Do you want to add this JSON data in the Database ?`;
      if (confirm(confirmMessage)) {
        jsonData.map((item) => {
          const cne = item.CNE;
          const Ex_M1 = item.Ex_M1;
          const Ex_M2 = item.Ex_M2;
          const Ex_M3 = item.Ex_M3;
          const Ex_M4 = item.Ex_M4;
          const Ex_M5 = item.Ex_M5;
          const Ex_M6 = item.Ex_M6;
          const Filiere = item.Filiere;
          const N_Apo = item.N_Apo;
          const Nom = item.Nom;
          const Prenom = item.Prenom;
          const Semestre = item.Semestre;
          let NTab_M1 = 0;
          let Loc_M1 = "";
          let Date_M1 = "";
          let Cr_M1 = "";
          let M1 = "";

          let NTab_M2 = 0;
          let Loc_M2 = "";
          let Date_M2 = "";
          let Cr_M2 = "";
          let M2 = "";

          let NTab_M3 = 0;
          let Loc_M3 = "";
          let Date_M3 = "";
          let Cr_M3 = "";
          let M3 = "";

          let NTab_M4 = 0;
          let Loc_M4 = "";
          let Date_M4 = "";
          let Cr_M4 = "";
          let M4 = "";

          let NTab_M5 = 0;
          let Loc_M5 = "";
          let Date_M5 = "";
          let Cr_M5 = "";
          let M5 = "";

          let NTab_M6 = 0;
          let Loc_M6 = "";
          let Date_M6 = "";
          let Cr_M6 = "";
          let M6 = "";

          if (Ex_M1 === 1) {
            NTab_M1 = item.NTab_M1;
            Loc_M1 = item.Loc_M1;
            Date_M1 = item.Date_M1;
            Cr_M1 = item.Cr_M1;
            M1 = item.M1;
          }
          if (Ex_M2 === 1) {
            NTab_M2 = item.NTab_M2;
            Loc_M2 = item.Loc_M2;
            Date_M2 = item.Date_M2;
            Cr_M2 = item.Cr_M2;
            M2 = item.M2;
          }
          if (Ex_M3 === 1) {
            NTab_M3 = item.NTab_M3;
            Loc_M3 = item.Loc_M3;
            Date_M3 = item.Date_M3;
            Cr_M3 = item.Cr_M3;
            M3 = item.M3;
          }
          if (Ex_M4 === 1) {
            NTab_M4 = item.NTab_M4;
            Loc_M4 = item.Loc_M4;
            Date_M4 = item.Date_M4;
            Cr_M4 = item.Cr_M4;
            M4 = item.M4;
          }
          if (Ex_M5 === 1) {
            NTab_M5 = item.NTab_M5;
            Loc_M5 = item.Loc_M5;
            Date_M5 = item.Date_M5;
            Cr_M5 = item.Cr_M5;
            M5 = item.M5;
          }
          if (Ex_M6 === 1) {
            NTab_M6 = item.NTab_M6;
            Loc_M6 = item.Loc_M6;
            Date_M6 = item.Date_M6;
            Cr_M6 = item.Cr_M6;
            M6 = item.M6;
          }

          const url = `http://localhost:8080/upload/save?cne=${cne}&Cr_M1=${Cr_M1}&Cr_M2=${Cr_M2}&Cr_M3=${Cr_M3}&Cr_M4=${Cr_M4}&Cr_M5=${Cr_M5}&Cr_M6=${Cr_M6}&Date_M1=${Date_M1}&Date_M2=${Date_M2}&Date_M3=${Date_M3}&Date_M4=${Date_M4}&Date_M5=${Date_M5}&Date_M6=${Date_M6}&Ex_M1=${Ex_M1}&Ex_M2=${Ex_M2}&Ex_M3=${Ex_M3}&Ex_M4=${Ex_M4}&Ex_M5=${Ex_M5}&Ex_M6=${Ex_M6}&Filiere=${Filiere}&Loc_M1=${Loc_M1}&Loc_M2=${Loc_M2}&Loc_M3=${Loc_M3}&Loc_M4=${Loc_M4}&Loc_M5=${Loc_M5}&Loc_M6=${Loc_M6}&M1=${M1}&M2=${M2}&M3=${M3}&M4=${M4}&M5=${M5}&M6=${M6}&NTab_M1=${NTab_M1}&NTab_M2=${NTab_M2}&NTab_M3=${NTab_M3}&NTab_M4=${NTab_M4}&NTab_M5=${NTab_M5}&NTab_M6=${NTab_M6}&N_Apo=${N_Apo}&Nom=${Nom}&Prenom=${Prenom}&Semestre=${Semestre}`;
          const response = fetch(url, {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify({}),
          });
        });
        alert("Added successfully");
      }
    };

    reader.readAsText(file);
  }

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const[log,setlog]= useState("");

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  function loginadmin() {
    fetch(
      `http://localhost:8080/login/admin?email=${encodeURIComponent(
        email
      )}&password=${encodeURIComponent(password)}`
    )
      .then((response) => response.json())
      .then((data) => {
        conn_user = data;
        setAid(data.id)
        handleShowAdminDiv();
      })
      .catch((error) => {});
  }
  const loginstudent = async () => {
    if (email!="" && password!="" && log!=""){
    try {
    
      const response = await fetch(
        `http://localhost:8080/login/etudiant?email=${email}&password=${password}`);
      const data = await response.json();
      handleShowStudentDiv(); 
      setConvData(data)
      setQrValue(data.id)
        
    } catch (error) { }
  }};
const [qrValue, setQrValue] = useState("");
  const YourComponent = () => {
    
    return (
      <Image
        src={`https://api.qrserver.com/v1/create-qr-code/?size=200x200&data=${qrValue}`}
        style={{
          justifyContent: "center",
          marginTop: "5px",
          width: "170px",
        }}
        alt="qr-code"
      />
    );
  };

  const handleLogin = () => {
    loginadmin();
    loginstudent();
    setlog("a");
  
  };

  function logout(){
    handleShowLoginDiv();
    conn_user = null ;
    conv_data = null ;
    setlog("");
    setEmail("");
    setPassword("");
    setConvData(null);
    setQrValue("");
   

  }
 
 const [convData, setConvData] = useState(null);

  const CalendarComponent = () => {
   
  
    const onPanelChange = (value, mode) => {
      // Handle panel change if needed
    };
  
    const dateCellRender = (value) => {
      
      // Update the calendar's data structure with the text for specific dates
      const dateTextMap = {
        [convData.date_M1]: "Exam de " + convData.m1 + " dans la salle " + convData.loc_M1 + " " + convData.cr_M1 + " ... numero du table " + convData.ntab_M1,
        [convData.date_M2]: "Exam de " + convData.m2 + " dans la salle " + convData.loc_M2 + " " + convData.cr_M2 + " ... numero du table " + convData.ntab_M2,
        [convData.date_M3]: "Exam de " + convData.m3 + " dans la salle " + convData.loc_M3 + " " + convData.cr_M3 + " ... numero du table " + convData.ntab_M3,
        [convData.date_M4]: "Exam de " + convData.m4 + " dans la salle " + convData.loc_M4 + " " + convData.cr_M4 + " ... numero du table " + convData.ntab_M4,
        [convData.date_M5]: "Exam de " + convData.m5 + " dans la salle " + convData.loc_M5 + " " + convData.cr_M5 + " ... numero du table " + convData.ntab_M5,
        [convData.date_M6]: "Exam de " + convData.m6 + " dans la salle " + convData.loc_M6 + " " + convData.cr_M6 + " ... numero du table " + convData.ntab_M6,
      };
    
      // Get the current date
      const currentDate = value.format('DD/MM/YYYY');
    
      // Retrieve the text for the current date
      const cellContent = dateTextMap[currentDate];
    
      return cellContent ? <div className="cell-text">{cellContent}</div> : null;
    };
    
  

  
    if (convData === null) {
      return null; // Don't render anything if convData is null
    }
  
    return (
      <Calendar
        onPanelChange={onPanelChange}
        mode="month"
        dateCellRender={dateCellRender}
      />
    );
  };
  

   const [Aid, setAid] = useState('');
  const ProfilePage = () => {
    const [inputValue, setInputValue] = useState('');

  
    const handleInputChange = (event) => {
      setInputValue(event.target.value);
    };
  
    const handlepassword = () => {
      fetch( ` http://localhost:8080/admins/${Aid}/?password=${(inputValue)}`)
        .then((response) => {
          if (response.ok) {
            return response.text();
          } else {
            throw new Error('Password update failed');
          }
        })
        .then((data) => {
          alert("Password updated");
        })
        .catch((error) => {
          // Handle error
          console.error(error);
          alert('Password update failed');
        });
    };
    

  
    return (
      <div className="wrapper">
        <header>
          <h1>Update Password</h1>
          <p>Paste a password or enter text </p>
        </header>
        <div className="form">
          <input
            type="text"
            spellCheck="false"
            placeholder="Enter New password"
            value={inputValue}
            onChange={handleInputChange}
          />
          <button onClick={handlepassword}>Update</button>
        </div>
      </div>
    );
  };


  const ProfilePage2 = () => {
    const [inputValue, setInputValue] = useState('');

  
    const handleInputChange = (event) => {
      setInputValue(event.target.value);
    };
  
    const handlepassword = () => {
      fetch(`http://localhost:8080/etudiants/${qrValue}/?password=${inputValue}`)
        .then((response) => {
          if (response.ok) {
            return response.text();
          } else {
            throw new Error('Password update failed');
          }
        })
        .then((data) => {
          alert("Password updated");
        })
        .catch((error) => {
          // Handle error
          console.error(error);
          alert('Password update failed');
        });
    };
    
  
    return (
      <div className="wrapper">
        <header>
          <h1>Update Password</h1>
          <p>Paste a password or enter text </p>
        </header>
        <div className="form">
          <input
            type="text"
            spellCheck="false"
            placeholder="Enter New password"
            value={inputValue}
            onChange={handleInputChange}
          />
          <button onClick={handlepassword}>Update</button>
        </div>
      </div>
    );
  };


 
const ListPage = () => {
  const [exams, setExams] = useState([]);
  const [students, setStudents] = useState([]);
   const [selectedExam, setSelectedExam] = useState('');
  const [selectedStudent, setSelectedStudent] = useState('');


  useEffect(() => {
    // Fetch exams API
    fetch('http://localhost:8080/exams/all')
      .then(response => response.json())
      .then(data => setExams(data))
      .catch(error => console.error(error));

    // Fetch students API
    fetch('http://localhost:8080/etudiants/all')
      .then(response => response.json())
      .then(data => setStudents(data))
      .catch(error => console.error(error));
  }, []);

  const handleAddStudent = () => {
    axios
      .put(`http://localhost:8080/exams/addstudent/${selectedStudent}?xid=${selectedExam}`)
      .then(response => {
        // Successful update
        alert('added successfully');
      })
      .catch(error => {
        // Error occurred
        console.error(error);
      });
  };

  return (
    <div className="wrapper">
      <header>
        <h1>Add Student to an Exam</h1>
        <p>Select Exam and Student</p>
      </header>
      <div className="form">
        <select id="list-page-select"
          value={selectedExam}
          onChange={e => setSelectedExam(e.target.value)}
        >
          {exams.map(exam => (
            <option key={exam.id} value={exam.id}  class="highlighted">
              {exam.code}
            </option>
          ))}
        </select>
        <select id="list-page-select"
             value={selectedStudent}
             onChange={e => setSelectedStudent(e.target.value)}
        >
          {students.map(student => (
            <option key={student.id} value={student.id}  class="highlighted">
              {student.nom} {student.prenom}
            </option>
          ))}
        </select>
        <button onClick={handleAddStudent} >ADD</button>
      </div>
    </div>
  );
};
  return (
    <div id="app">
      <MDBContainer fluid>
        <MDBRow className="d-flex justify-content-center align-items-center h-100">
          <MDBCol col="12">
            <div
              id="login-section"
              style={{ display: ShowLoginDiv ? "block" : "none" }}
            >
              <MDBCard 
                className=" text-white my-5 mx-auto"
                style={{ borderRadius: "1rem", maxWidth: "400px" }}
              >
                <MDBCardBody className="p-5 d-flex flex-column align-items-center mx-auto w-100" id="login-form">
                  <h2 className="fw-bold mb-2 text-uppercase" >Login</h2>
                  <p  id="form_text" className="small mb-3 pb-lg-2" >
                    Please enter your login and password!
                  </p>
                  <MDBInput
                    wrapperClass="mb-4 mx-5 w-100"
                    labelClass="text-black"
                    label="Email address"
                    id="formEmail"
                    type="email"
                    size="lg"
                    value={email}
                    onChange={handleEmailChange}
                  />
                  <MDBInput
                    wrapperClass="mb-4 mx-5 w-100"
                    labelClass="text-black"
                    label="Password"
                    id="formPassword"
                    type="password"
                    size="lg"
                    value={password}
                    onChange={handlePasswordChange}
                  />
         
                  <MDBBtn
                    id="loginbnt"               
                    className="mx-2 px-5"   
                    size="lg"
                    onClick={handleLogin}
                  >
                    Login
                  </MDBBtn>
                </MDBCardBody>
              </MDBCard>
            </div>
          </MDBCol>
        </MDBRow>

        <div
          id="admin-section"
          style={{ display: ShowAdminDiv ? "block" : "none" }}
        >
          <MDBNavbar id="navbar">
            <MDBContainer fluid>
              <div>
              <button
                  onClick={() => logout()}
                  id="nav-middle-btn"
                  type="button"
                  class="btn  btn-floating"
                >
                  <i id="nav-icon" class="fas fa-power-off " ></i>
                  
                </button>
                <button
                  onClick={() => handleBasicClick("list")}
                  id="nav-middle-btn"
                  type="button"
                  class="btn  btn-floating"
                > 
                  <i id="nav-icon" class="fas fa-list"></i>
                </button>
                <button
                  onClick={() => handleBasicClick("upload")}
                  id="nav-middle-btn"
                  type="button"
                  class="btn  btn-floating"
                >
                  <i id="nav-icon" class="fas fa-upload"></i>
                </button>
              </div>

              <a
                class="dropdown-toggle d-flex align-items-center hidden-arrow"
                id="navbarDropdownMenuAvatar"
                role="button"
                data-mdb-toggle="dropdown"
                aria-expanded="false"
              >
                <img
                  src="/images/profile.png"
                  class="rounded-circle"
                  height="45"
                  loading="lazy"
                  onClick={() => handleBasicClick("profile")}
                />
              </a>
            </MDBContainer>
          </MDBNavbar>
          <MDBTabsContent>
            <MDBTabsPane show={basicActive === "upload"}>
              <div id="upload-page">
                <MDBContainer>
                  <form
                    id="file-form"
                    onClick={() =>
                      document.querySelector(".input-field").click()
                    }
                  >
                    <input
                      id="input-field"
                      type="file"
                      accept=".json"
                      className="input-field"
                      hidden
                      onChange={(event) => {
                        readJSONFile(event.target.files[0]);
                      }}
                    ></input>
                    <MDBIcon
                      fas
                      icon="cloud-upload-alt"
                      id="input-field-icon"
                    />
                    <p id="input-field-icon">Drag & Drop to upload</p>
                    <div id="input-filed-button">Select a file</div>
                  </form>
                </MDBContainer>
              </div>
            </MDBTabsPane>
            <MDBTabsPane show={basicActive === "list"}>
            <div id="list-page">
            <ListPage />
              </div>



            </MDBTabsPane>
            <MDBTabsPane show={basicActive === "profile"}><ProfilePage /></MDBTabsPane>
          </MDBTabsContent>
        </div>

        <div
          id="admin-section"
          style={{ display: ShowStudentDiv ? "block" : "none" }}
        >
          <MDBNavbar id="navbar">
            <MDBContainer fluid>
              <div>
              <button
                  onClick={() => logout()}
                  id="nav-middle-btn"
                  type="button"
                  class="btn  btn-floating"
                >
                  <i id="nav-icon" class="fas fa-power-off " ></i>
                  
                </button>
                <button
                  onClick={() => handleBasicClick2("calendar")}
                  id="nav-middle-btn"
                  type="button"
                  class="btn  btn-floating"
                >
                  <i id="nav-icon" class="fas fa-calendar"></i>
                </button>
                <button
                  onClick={() => handleBasicClick2("convocation")}
                  id="nav-middle-btn"
                  type="button"
                  class="btn  btn-floating"
                >
                  <i id="nav-icon" class="fas fa-scroll"></i>
                </button>
              </div>

              <a
                class="dropdown-toggle d-flex align-items-center hidden-arrow"
                id="navbarDropdownMenuAvatar"
                role="button"
                data-mdb-toggle="dropdown"
                aria-expanded="false"
              >
                <img
                  src="/images/profile.png"
                  class="rounded-circle"
                  height="45"
                  loading="lazy"
                  onClick={() => handleBasicClick2("profile2")}
                />
              </a>
            </MDBContainer>
          </MDBNavbar>
          <MDBTabsContent>
            <MDBTabsPane show={basicActive2 === "calendar"}>
            <CalendarComponent/>
            </MDBTabsPane>

            <MDBTabsPane show={basicActive2 === "convocation"}>
              <div style={{ display: "flex", height: "100vh", width: "99vw" }}>
                <PDFViewer style={{ width: "100%" }}>
                  <Document>
                    <Page>
                      <View
                        style={{
                          flexDirection: "row",
                          justifyContent: "space-between",
                        }}
                      >
                        <Image
                          src="/images/logoEmsi.png"
                          style={{
                            width: "30%",
                            height: "50px",
                            alignSelf: "flex-start",
                            marginLeft: "5px",
                            marginTop: "5px",
                          }}
                        />
                      </View>

                      <View
                        style={{
                          display: "flex",
                          justifyContent: "center",
                          alignItems: "center",
                          marginTop: "10px",
                        }}
                      >
                        <Text
                          style={{
                            fontSize: 40,
                            color: "black",
                            marginBottom: 10,
                            textAlign: "center",
                          }}
                        >
                          Convocation
                        </Text>
                      </View>
                      <View
                        style={{
                          display: "flex",
                          justifyContent: "center",
                          alignItems: "center",
                        }}
                      >
                        <Text
                          style={{
                            fontSize: 12,
                            color: "grey",
                            marginBottom: 10,
                            textAlign: "center",
                          }}
                        >
                          Cher étudiant(e), nous vous convoquons pour passer
                          votre examen. Votre présence est essentielle pour
                          évaluer vos connaissances et compétences. Soyez
                          prêt(e) à donner le meilleur de vous-même!
                        </Text>
                      </View>
                      <View
                        style={{
                          display: "flex",
                          justifyContent: "center",
                          alignItems: "center",
                        }}
                      >
                        <YourComponent />
                      </View>
                    </Page>
                  </Document>
                </PDFViewer>
              </div>
            </MDBTabsPane>

            <MDBTabsPane show={basicActive2 === "profile2"}><ProfilePage2 /></MDBTabsPane>
          </MDBTabsContent>
        </div>
      </MDBContainer>
    </div>
  );
}

export default App;
