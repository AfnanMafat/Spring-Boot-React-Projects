import React from 'react'
import { Route, Router, Routes } from 'react-router-dom'
import UserLogin from '../Component/User/UserLogin'
import UserHome from '../Component/User/UserHome'
import UserSignUp from '../Component/User/UserSignUp'

export default function Routing() {
  return (
    <>
        <Routes>
            <Route path='/' element={<UserLogin />}></Route>
            <Route path='/UserHome' element={<UserHome />}></Route>
            <Route path='/UserSignUp' element={<UserSignUp />}></Route>
        </Routes>
    </>
  )
}
