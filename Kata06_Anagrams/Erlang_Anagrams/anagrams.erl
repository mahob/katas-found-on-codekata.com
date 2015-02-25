-module(anagrams).
-export([read_wordlist/1]).
-import(lists, [delete/2, sort/2]).

read_wordlist(FileName) ->
  Dict = for_each_line_in_file(FileName, [read, {encoding, utf8}]),
  Anagrams = [Values || {_, Values} <- dict:to_list(Dict)],
  Sorted = sort(fun(A, B) -> length(A) >= length(B) end, clean(Anagrams)),
  [io:format(string:join(L, ", ") ++ "~n") || L <- Sorted].

clean(List) ->
  clean(List, List).

clean([H|T], Keep) ->
  case length(H) =< 1 of
    true  -> clean(T, delete(H, Keep));
    false -> clean(T, Keep)
  end;
clean([], Keep) ->
  Keep.

for_each_line_in_file(Name, Mode) ->
  {ok, Device} = file:open(Name, Mode),
  for_each_line(Device, dict:new(), 0).

% Remove leading and trailing whitespaces
% (string:split doesn't remove readling/trailing line feeds)
strip(Text) ->
  re:replace(Text, "(^\\s+)|(\\s+$)", "", [global,{return,list}]).

for_each_line(Device, Dict, LineNumber) ->
  case io:get_line(Device, "") of
    eof  ->
      file:close(Device),
      Dict;
    Data ->
      Line = strip(Data),
      Anagram = lists:sort(Line),
      NewDict = dict:update(Anagram, fun(Old) -> Old ++ [Line] end, [Line], Dict),
      for_each_line(Device, NewDict, LineNumber + 1)
  end.
