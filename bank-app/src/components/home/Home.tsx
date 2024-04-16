import axios from 'axios';
import { useState } from 'react';
import './hme.css';

function Home() {
    interface account{
        accountNo: String,
    name: String,
    ifsc: String,
    branch: String,
    address: String,
    phNo: String,
    balance: Int16Array
    }
const[errorMsg,setErrorMsg]=useState<string>("");
const [accountData, setAccountData] = useState<account>([]);
const [withdraw,setWithdraw]=useState<Int32Array>();
const[withdrawData,setWithdrawData]=useState<string>();
const[deposit,setDeposit]=useState<Int32Array>();
const[depositData,setDepositData]=useState<string>();




    const handleSubmit = (e:any) => {
        e.preventDefault();
       
            axios
              .get("http://localhost:8081/acc/"+accountData.name)
              .then((res) => {
                console.log(res);
                setAccountData(res.data);
                if(res.data==accountData){
                    setErrorMsg("Invalid user");
                }
              })
              .catch((error) => {
                console.error("Page not found");
          
                setErrorMsg(error.message);
              });
          
    };

    const handleWithdraw = (e:any) => {
        e.preventDefault();
       
            axios
              .get("http://localhost:8081/acc/"+accountData.name+"/{no}?no="+withdraw)
              .then((res) => {
                console.log(res);
                setWithdrawData(res.data);
                if(res.data==null){
                    setWithdrawData("insufficient balance")
                }
              })
              .catch((error) => {
                console.error("Page not found");
          
                setErrorMsg(error.message);
              });
          
    };

    const handleDeposit = (e:any) => {
        e.preventDefault();
       
            axios
              .get("http://localhost:8081/accs/"+accountData.name+"/{no}?no="+deposit)
              .then((res) => {
                console.log(res);
                setDepositData(res.data);
                
              })
              .catch((error) => {
                console.error("Page not found");
          
                setErrorMsg(error.message);
              });
          
    };
   

    return (
        <div className="home-page">
            <header>
                <h1>Welcome to Your Bank</h1>
            </header>
            <main>
                <div className="background"></div>
                <section className="account-summary">
                    <h2>Account Summary</h2>
                    
                    <td>Name : {accountData.name}</td><br />
                    <td>A/c No : {accountData.accountNo}</td><br />
                    <td >IFSC :{accountData.ifsc} </td><br />
                    <td>Phone No: {accountData.phNo} </td><br />
                    <td>Branch Id:{accountData.branch} </td><br />
                    <td>Avl Bal: {accountData.balance}</td>
                    
                </section>
                <section className="transactions">
                    <h2>Transactions</h2>
                    <form onSubmit={handleSubmit}>
                        <input
                            type="text"
                            placeholder="Enter A/c Name"
                            onChange={(e)=>setAccountData({...accountData,name:e.currentTarget.value})} 
                            required
                        />
                    {errorMsg && <div style={{ color: 'red' }}>{errorMsg}</div>}
                        <button type="submit" onClick={handleSubmit}>Submit</button>
                    </form>
                </section>
                <section className="actions">
                    <h2>Actions</h2>
                    <div className="action-buttons">
                        <input
                            type="number"
                            placeholder="Amount"
                            onChange={(e)=>setWithdraw(e.currentTarget.value)}
                        />
                        <button onClick={handleWithdraw}>Withdraw</button>
                        {withdrawData}
                        <input
                            type="number"
                            placeholder="Amount"
                            onChange={(e) => setDeposit(e.target.value)}
                        />
                        <button onClick={handleDeposit}>Deposit</button>
                        {depositData}
                    </div>
                </section>
            </main>
            <footer>
                <p>&copy; 2024 Your Bank. All rights reserved.</p>
            </footer>
        </div>
    );
}

export default Home;
