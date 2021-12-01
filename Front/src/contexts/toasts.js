import 'react-toastify/dist/ReactToastify.css';

import { useContext, createContext, useCallback } from 'react'
import { toast, ToastContainer } from 'react-toastify';

const ToastsContext = createContext({})


export function ToastsProvider(props) {
    const addToast = useCallback(({ type = 'info', title = '', closeTime = 5000 }) => {
        const types = ['success', 'info', 'warn', 'error']

        if (!types.includes(type)) type = 'info'

        const createToast = toast[type];

        createToast(title, {
            autoClose: closeTime,
            position: toast.POSITION.TOP_RIGHT
        })
    }, [])

    return (
        <ToastsContext.Provider value={{ addToast }}>
            {props.children}
            <ToastContainer />
        </ToastsContext.Provider>
    )
}

export function useToastsContext() {
    const toastsContext = useContext(ToastsContext)

    if (toastsContext == null) throw new Error('Componente precisa estar dentro do contexto de Toasts')

    return toastsContext
}