<h1>Принципы работы:</h1>
  <ul>
    <li>Данные полученны по API с сайта ЦБ РФ в формате JSON. Затем идет сохранение в базу данных. При закрытии приложения и при повороте экрана обновление НЕ происходит.</li>
    <li>В приложении есть нижнее меню из 3 вкладок. Я добавила 3 вкладку инфо, т.к. в MATERIAL DESIGN есть уточнение, что в нижнем меню необходимо имень от 3 до 5 вкладок.</li>
    <li>На главной странице отображается курс валют в соотношении 1 валюта = n рублей. И есть значок обновления данных в верхнем меню.</li>
    <li>Так же есть автоматическое обновление (для примера выставлен таймер на каждые 20 секунд).</li>
    <li>Во вкладке "обмен валют" можно поменять рубли в выбранную валюту</li>
    <li>Во вкладке "информация о приложении" небольшое описание основных функций</li>
  </ul>
  
  <h1>Библиотеки:</h1>
<ul>
    <li>Retrofit - удобная популярная библиотека для работы с API</li>
    <li>Android Bottom Navigation - простая в использовании библиотека для простой навигации.</li>
    <li>Rx-Java для многопоточности - просто решила попробовать.</li>
    <li>Room - для автоматизации работы с SQLite. Чище код, меньше вероятность допустить ошибки в написании запросов.</li>
  </ul>
