import axios from "axios";
import React from "react";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";

export default function Todos() {
  const [todo, setTodo] = React.useState();
  const [priority, setPriority] = React.useState();
  const [description, setDescription] = React.useState();
  const [status, setStatus] = React.useState("Pending");
  const [date, setDate] = React.useState(new Date());
  const [view, setView] = React.useState(false);
  const [todos, setTodos] = React.useState([]);

  React.useEffect(() => {
    axios
      .get("http://localhost:8080/GetAll")
      .then((response) => {
        setTodos(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const handleSubmit = (event) => {
    event.preventDefault();

    const formattedDate = date.toISOString().split("T")[0];

    axios
      .post("http://localhost:8080/Insert", {
        title: todo,
        priority: priority,
        description: description,
        status: status,
        due_date: formattedDate,
      })
      .then((response) => {
        console.log(response);
        axios
          .get("http://localhost:8080/GetAll")
          .then((response) => {
            setTodos(response.data);
          })
          .catch((error) => {
            console.log(error);
          });
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleDelete = (id) => {
    axios
      .delete(`http://localhost:8080/Delete/${id}`)
      .then((response) => {
        console.log(response);
        setTodos(todos.filter((todo) => todo.id !== id));
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleDone = (todo) => {
    axios
      .put(`http://localhost:8080/Update/${todo.id}`, {
        title: todo.title,
        priority: todo.priority,
        description: todo.description,
        status: "Completed",
        due_date: todo.due_date,
      })
      .then((response) => {
        console.log(response);
        axios
          .get("http://localhost:8080/GetAll")
          .then((response) => {
            setTodos(response.data);
          })
          .catch((error) => {
            console.log(error);
          });
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const getPriorityColor = (priority) => {
    switch (priority) {
      case "High":
        return "bg-red-100 text-red-800";
      case "Medium":
        return "bg-yellow-100 text-yellow-800";
      case "Low":
        return "bg-green-100 text-green-800";
      default:
        return "bg-gray-100 text-gray-800";
    }
  };

  const getStatusColor = (status) => {
    return status === "Completed"
      ? "bg-green-100 text-green-800"
      : "bg-yellow-100 text-yellow-800";
  };

  return (
    <div className="min-h-screen bg-gradient-to-br from-purple-50 via-blue-50 to-pink-50 py-12 px-4 sm:px-6">
      <div className="max-w-6xl mx-auto">
        <div className="text-center mb-10">
          <h1 className="text-5xl font-extrabold text-transparent bg-clip-text bg-gradient-to-r from-purple-600 via-pink-500 to-red-500 mb-3">
            Task Manager
          </h1>
          <p className="text-lg text-purple-600 font-medium">
            Organize your tasks efficiently
          </p>
          <div className="w-32 h-1 bg-gradient-to-r from-purple-500 to-pink-500 mx-auto mt-4 rounded-full"></div>
        </div>

        <div className="flex flex-col lg:flex-row gap-8">
          <div className="w-full lg:w-2/5 bg-white rounded-2xl shadow-xl p-6 sm:p-8">
            <h2 className="text-2xl font-bold text-gray-800 mb-6 bg-gradient-to-r from-purple-500 to-blue-500 bg-clip-text text-transparent">
              Add New Task
            </h2>

            <form onSubmit={handleSubmit} className="space-y-6">
              <div className="grid grid-cols-1 gap-6">
                <div>
                  <label className="block text-sm font-medium text-gray-700 mb-2">
                    <span className="flex items-center">
                      <span className="w-2 h-2 bg-purple-500 rounded-full mr-2"></span>
                      Task Title
                    </span>
                  </label>
                  <input
                    type="text"
                    onChange={(e) => setTodo(e.target.value)}
                    placeholder="Add a new task"
                    className="w-full px-4 py-3 rounded-xl border border-gray-300 focus:outline-none focus:ring-2 focus:ring-purple-500 focus:border-transparent transition bg-gray-50"
                    required
                  />
                </div>

                <div>
                  <label className="block text-sm font-medium text-gray-700 mb-2">
                    <span className="flex items-center">
                      <span className="w-2 h-2 bg-pink-500 rounded-full mr-2"></span>
                      Priority
                    </span>
                  </label>
                  <select
                    name="priority"
                    onChange={(e) => setPriority(e.target.value)}
                    id="priority"
                    className="w-full px-4 py-3 rounded-xl border border-gray-300 focus:outline-none focus:ring-2 focus:ring-pink-500 focus:border-transparent transition bg-gray-50"
                    required
                  >
                    <option
                      value={""}
                      disabled
                      selected
                      className="text-gray-400"
                    >
                      Select Priority
                    </option>
                    <option value={"Low"} className="text-green-600">
                      Low
                    </option>
                    <option value={"Medium"} className="text-yellow-600">
                      Medium
                    </option>
                    <option value={"High"} className="text-red-600">
                      High
                    </option>
                  </select>
                </div>
              </div>

              <div>
                <label className="block text-sm font-medium text-gray-700 mb-2">
                  <span className="flex items-center">
                    <span className="w-2 h-2 bg-blue-500 rounded-full mr-2"></span>
                    Description
                  </span>
                </label>
                <textarea
                  placeholder="Add detailed description"
                  name="description"
                  onChange={(e) => setDescription(e.target.value)}
                  className="w-full px-4 py-3 rounded-xl border border-gray-300 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition h-32 bg-gray-50"
                />
              </div>

              <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                <div>
                  <label className="block text-sm font-medium text-gray-700 mb-2">
                    <span className="flex items-center">
                      <span className="w-2 h-2 bg-yellow-500 rounded-full mr-2"></span>
                      Status
                    </span>
                  </label>
                  <button
                    onClick={() =>
                      setStatus(status === "Pending" ? "Completed" : "Pending")
                    }
                    className={`w-full px-4 py-3 rounded-xl font-medium transition-all ${
                      status === "Pending"
                        ? "bg-gradient-to-r from-yellow-400 to-yellow-500 text-white shadow-lg"
                        : "bg-gradient-to-r from-green-400 to-green-500 text-white shadow-lg"
                    }`}
                    disabled
                  >
                    {status}
                  </button>
                </div>

                <div>
                  <label className="block text-sm font-medium text-gray-700 mb-2">
                    <span className="flex items-center">
                      <span className="w-2 h-2 bg-indigo-500 rounded-full mr-2"></span>
                      Due Date
                    </span>
                  </label>
                  <div className="rounded-xl overflow-hidden border border-gray-300 bg-gradient-to-br from-indigo-50 to-purple-50">
                    <Calendar
                      onChange={setDate}
                      value={date}
                      minDate={new Date()}
                      className="border-0 w-full bg-transparent"
                    />
                  </div>
                </div>
              </div>

              <div className="flex justify-center pt-4">
                <button
                  type="submit"
                  className="px-10 py-4 bg-gradient-to-r from-purple-600 to-pink-600 text-white font-bold rounded-xl shadow-lg hover:from-purple-700 hover:to-pink-700 transition-all transform hover:-translate-y-1 focus:ring-2 focus:ring-purple-400 focus:outline-none text-lg flex items-center"
                >
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    className="h-5 w-5 mr-2"
                    viewBox="0 0 20 20"
                    fill="currentColor"
                  >
                    <path
                      fillRule="evenodd"
                      d="M10 18a8 8 0 100-16 8 8 0 000 16zm1-11a1 1 0 10-2 0v2H7a1 1 0 100 2h2v2a1 1 0 102 0v-2h2a1 1 0 100-2h-2V7z"
                      clipRule="evenodd"
                    />
                  </svg>
                  Add Task
                </button>
              </div>
            </form>
          </div>

          <div className="w-full lg:w-3/5">
            <div className="flex justify-between items-center mb-6">
              <h2 className="text-2xl font-bold text-gray-800 bg-gradient-to-r from-blue-500 to-indigo-500 bg-clip-text text-transparent">
                Your Tasks
              </h2>
              <button
                onClick={() => setView(!view)}
                className="px-5 py-2.5 bg-gradient-to-r from-indigo-500 to-purple-500 text-white font-medium rounded-lg shadow-md hover:from-indigo-600 hover:to-purple-600 transition-all flex items-center"
              >
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  className="h-5 w-5 mr-1"
                  viewBox="0 0 20 20"
                  fill="currentColor"
                >
                  <path
                    d={
                      view
                        ? "M10 12a2 2 0 100-4 2 2 0 000 4z"
                        : "M10 12a2 2 0 100-4 2 2 0 000 4zM3.071 4.929a9.969 9.969 0 0114.142 0 9.969 9.969 0 010 14.142 9.969 9.969 0 01-14.142 0 9.969 9.969 0 010-14.142z"
                    }
                  />
                  <path
                    fillRule="evenodd"
                    d={
                      view
                        ? "M4.929 4.929a9.968 9.968 0 00-1.897 2.564 9.97 9.97 0 000 7.014 9.968 9.968 0 001.897 2.564 9.968 9.968 0 002.564 1.897 9.97 9.97 0 007.014 0 9.968 9.968 0 002.564-1.897 9.968 9.968 0 001.897-2.564 9.97 9.97 0 000-7.014 9.968 9.968 0 00-1.897-2.564 9.968 9.968 0 00-2.564-1.897 9.97 9.97 0 00-7.014 0 9.968 9.968 0 00-2.564 1.897zM10 2a8 8 0 100 16 8 8 0 000-16z"
                        : ""
                    }
                    clipRule="evenodd"
                  />
                </svg>
                {view ? "Hide Tasks" : "Show Tasks"}
              </button>
            </div>

            {view && (
              <div className="bg-white rounded-2xl shadow-xl overflow-hidden">
                {todos.length === 0 ? (
                  <div className="text-center py-12">
                    <div className="inline-block p-4 rounded-full bg-gradient-to-br from-purple-100 to-pink-100 mb-4">
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        className="h-12 w-12 text-purple-500"
                        fill="none"
                        viewBox="0 0 24 24"
                        stroke="currentColor"
                      >
                        <path
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          strokeWidth={2}
                          d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2"
                        />
                      </svg>
                    </div>
                    <h3 className="text-xl font-semibold text-gray-700 mb-2">
                      No tasks yet!
                    </h3>
                    <p className="text-gray-500 max-w-md mx-auto">
                      Add your first task using the form to get started. Your
                      tasks will appear here.
                    </p>
                  </div>
                ) : (
                  <div className="overflow-x-auto">
                    <table className="min-w-full divide-y divide-gray-200">
                      <thead className="bg-gradient-to-r from-blue-500 to-indigo-500 text-white">
                        <tr>
                          <th
                            scope="col"
                            className="px-6 py-3 text-left text-xs font-bold uppercase tracking-wider"
                          >
                            Title
                          </th>
                          <th
                            scope="col"
                            className="px-6 py-3 text-left text-xs font-bold uppercase tracking-wider"
                          >
                            Priority
                          </th>
                          <th
                            scope="col"
                            className="px-6 py-3 text-left text-xs font-bold uppercase tracking-wider"
                          >
                            Description
                          </th>
                          <th
                            scope="col"
                            className="px-6 py-3 text-left text-xs font-bold uppercase tracking-wider"
                          >
                            Status
                          </th>
                          <th
                            scope="col"
                            className="px-6 py-3 text-left text-xs font-bold uppercase tracking-wider"
                          >
                            Date
                          </th>
                          <th
                            scope="col"
                            className="px-6 py-3 text-left text-xs font-bold uppercase tracking-wider"
                          >
                            Action
                          </th>
                        </tr>
                      </thead>
                      <tbody className="bg-white divide-y divide-gray-200">
                        {todos.map((todo) => (
                          <tr
                            key={todo.id}
                            className="hover:bg-gray-50 transition-colors"
                          >
                            <td className="px-6 py-4 whitespace-nowrap">
                              <div className="text-sm font-medium text-gray-900">
                                {todo.title}
                              </div>
                            </td>
                            <td className="px-6 py-4 whitespace-nowrap">
                              <span
                                className={`px-3 py-1 inline-flex text-xs leading-5 font-semibold rounded-full ${getPriorityColor(
                                  todo.priority
                                )}`}
                              >
                                {todo.priority}
                              </span>
                            </td>
                            <td className="px-6 py-4">
                              <div className="text-sm text-gray-500 max-w-xs truncate">
                                {todo.description}
                              </div>
                            </td>
                            <td className="px-6 py-4 whitespace-nowrap">
                              <span
                                className={`px-3 py-1 inline-flex text-xs leading-5 font-semibold rounded-full ${getStatusColor(
                                  todo.status
                                )}`}
                              >
                                {todo.status}
                              </span>
                            </td>
                            <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                              {todo.due_date}
                            </td>
                            <td className="px-6 py-4 whitespace-nowrap text-sm font-medium">
                              <div className="flex flex-row gap-2">
                                {todo.status === "Pending" ? <button
                                  onClick={() => handleDone(todo)}
                                  className="flex items-center justify-center px-3 py-2 bg-green-500 text-white rounded-lg hover:bg-green-600 transition-colors"
                                >
                                  <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    className="h-5 w-5 mr-1"
                                    viewBox="0 0 20 20"
                                    fill="currentColor"
                                  >
                                    <path
                                      fillRule="evenodd"
                                      d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"
                                      clipRule="evenodd"
                                    />
                                  </svg>
                                  Done
                                </button> : ""}
                                <button
                                  onClick={() => handleDelete(todo.id)}
                                  className="flex items-center justify-center px-3 py-2 bg-red-500 text-white rounded-lg hover:bg-red-600 transition-colors"
                                >
                                  <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    className="h-5 w-5 mr-1"
                                    viewBox="0 0 20 20"
                                    fill="currentColor"
                                  >
                                    <path
                                      fillRule="evenodd"
                                      d="M9 2a1 1 0 00-.894.553L7.382 4H4a1 1 0 000 2v10a2 2 0 002 2h8a2 2 0 002-2V6a1 1 0 100-2h-3.382l-.724-1.447A1 1 0 0011 2H9zM7 8a1 1 0 012 0v6a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v6a1 1 0 102 0V8a1 1 0 00-1-1z"
                                      clipRule="evenodd"
                                    />
                                  </svg>
                                  Delete
                                </button>
                              </div>
                            </td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  </div>
                )}
              </div>
            )}
          </div>
        </div>

        <div className="text-center mt-12 text-gray-600 text-sm">
          <p className="flex items-center justify-center">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              className="h-4 w-4 mr-1 text-purple-500"
              viewBox="0 0 20 20"
              fill="currentColor"
            >
              <path
                fillRule="evenodd"
                d="M5 9V7a5 5 0 0110 0v2a2 2 0 012 2v5a2 2 0 01-2 2H5a2 2 0 01-2-2v-5a2 2 0 012-2zm8-2v2H7V7a3 3 0 016 0z"
                clipRule="evenodd"
              />
            </svg>
            Your tasks are saved securely and synced across devices All Right
            Reserved @Afnan Mafat
          </p>
        </div>
      </div>
    </div>
  );
}
