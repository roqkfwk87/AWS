import { create } from "zustand";

interface UserStore {
    loginUserId: String,
    setLoginUserId : (loginUserId: string) => void,
    loginUserRole: string,
    setLoginUserRole: (loginUserRole: string) => void, 
}

const useUserStore = create<UserStore>(set => ({
    loginUserId : '',
    setLoginUserId: (loginUserId: String) => set(state => ({ ...state, loginUserId})),
    loginUserRole: '',
    setLoginUserRole: (loginUserRole: string) => set(state => ({ ...state, loginUserRole}))
}));

export default useUserStore;